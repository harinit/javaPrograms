package arrays;


import java.util.Arrays;

public class LargestIntegerFinder {

    public static int findLargest(int[] arr, int target) {

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        int largest = Integer.MIN_VALUE;

        System.out.println("INTEGER.MIN_VALUE: " + Integer.MIN_VALUE); // -2147483648

        // Step 2: Find the largest integer smaller than target
        for (int num : arr) { // Loop through each number in the array.
            if (num > largest && num < target) { // Update 'largest' if 'num' is larger than the current 'largest' and
                                                 // smaller than 'target'.
                // Note: We use 'num < target' instead of 'num <= target' because we want to
                // exclude 'target' itself.
                largest = num;
            }
        }

        return largest;
    }

    //smallest integer greater than the given target in a sorted array.
    public static int findSmallestLarger(int[] arr, int target) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        int left = 0, right = arr.length - 1;
    //  left = 0 → Points to the start of the array.
	// right = arr.length - 1 → Points to the end of the array.
        int smallestLarger = Integer.MAX_VALUE;

        // Step 2: Binary search for the x number larger than target
        while (left <= right) {
            // •	The loop continues as long as left is less than or equal to right.
            // •	This ensures that the entire search space is checked.
            //FIND THE MIDDLE ELEMENT OF THE ARRAY
            int mid = left + (right - left) / 2;

            // •	mid is the middle index of the current search range.
            // •	Formula Explanation:
            // •	(left + right) / 2 might cause integer overflow in some cases.
            // •	Instead, left + (right - left) / 2 is used to avoid overflow.

            if (arr[mid] > target) {
                smallestLarger = arr[mid];  // Possible candidate
                right = mid - 1;  // Search left half
                // •	If arr[mid] > target:
                // •	arr[mid] is a valid candidate (it is greater than target).
                // •	Update smallestLarger = arr[mid].
                // •	Move right = mid - 1 to search in the left half for a potentially smaller valid candidate.
            } else {
                left = mid + 1; // Search right half
                // If arr[mid] <= target:
                // •	Ignore mid and move to the right half (left = mid + 1).
                // •	We are looking for numbers strictly greater than target, so we discard mid.
            }
        }

        // EXAMPLE:
        // int[] arr = {10, 15, 20, 25, 30, 35};  // Sorted Array
        // int target = 22;

        /* Iteration	left	right	mid	    arr[mid]	Comparison	    smallestLarger	        Next Move
                1	      0	       5	  2	    20	        20 ≤ 22	        No Change	            Search Right (left = 3)
                2	      3	       5	  4	    30	        30 > 22	        Update = 30	            Search Left (right = 3)
                3	      3	       3	  3	    25	        25 > 22	        Update = 25	            Search Left (right = 2)
                End	      3	       2	  -	    -	        -	            Smallest Larger = 25    Exit Loop 
                
                
                Step	                Time Complexity
                Sorting the array	    O(n log n)
                Binary search	        O(log n)
                Total Complexity	    O(n log n)

                Since binary search divides the array by 2 in each step, its complexity is O(log n).

                Key Takeaways
	1.	Binary Search is efficient (O(log n)) for finding the smallest larger element.
	2.	If arr[mid] > target, store arr[mid] and search left.
	3.	If arr[mid] <= target, search right.
	4.	Final smallestLarger contains the closest larger element.
                */
        return smallestLarger;
    }

    public static void main(String[] args) {
        int[] arr = { 10, -5, 20, 15, -8, 30 ,0};
        int target = 25;

        // • 10: 10 > largest (true) and 10 < target (true) → Update largest = 10.
        // • -5: -5 > largest (false) → Skip.
        // • 20: 20 > largest (true) and 20 < target (true) → Update largest = 20.
        // • 15: 15 > largest (false) → Skip.
        // • -8: -8 > largest (false) → Skip.
        // • 30: 30 > largest (true) but 30 < target (false) → Skip.

        
        int result = findLargest(arr, target);

        int res = findSmallestLarger(arr, target);

        if (result == Integer.MIN_VALUE) {
            System.out.println("No integer found smaller than the target.");
        } else {
            System.out.println("Largest integer smaller than target: " + result);
        }

        if(res == Integer.MIN_VALUE) {
            System.out.println("Hello *** No integer found larger than the target.");
        } else {
            System.out.println("Hello *** Smallest integer larger than target: " + res);
        }
    }

    // Time Complexity
    /* Approach	    Sorting Time	Search Time	    Total Time
    Linear Search	O(n log n)	    O(n)	        O(n log n)
    Binary Search	O(n log n)	    O(log n)	    O(n log n) 
    
    Even though binary search reduces the search time from O(n) to O(log n), sorting still dominates with O(n log n).
    Final Takeaways
	1.	Sorting first makes the search process faster and allows the use of binary search.
	2.	Using binary search reduces search time to O(log n), making the approach more efficient.
	3.	If the array is large and unsorted, sorting takes O(n log n), so sorting only makes sense if you need multiple queries on the same array.
*/
    /*
     * Edge Cases:
     * 1. No Element Meets the Condition:
     * • If all elements are greater than or equal to the target, largest remains
     * Integer.MIN_VALUE, and the program prints:
     * "No integer found smaller than the target."
     * 
     * 2. All Elements are the Same:
     * • If all elements in the array are the same, largest will be the same as the
     * first element in the array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 10"
     * 
     * 3. All Elements are Negative:
     * • If all elements in the array are negative, largest remains
     * Integer.MIN_VALUE, and the program prints:
     * "No integer found smaller than the target."
     * 
     * 4. All Elements are Positive:
     * • If all elements in the array are positive, the largest element smaller than
     * the target will be the largest element in the array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     * 
     * 5. Array Contains Negative and Positive Elements:
     * • If the array contains both negative and positive elements, the largest
     * element smaller than the target will be the largest positive element in the
     * array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     * 
     * 6. Array Contains Zero:
     * • If the array contains zero, the largest element smaller than the target
     * will be the largest positive element in the array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     * 
     * 7. Array Contains Only One Element:
     * • If the array contains only one element, that element will be the largest
     * integer smaller than the target.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 10"
     * 
     * 8. Array is Empty:
     * • If the array is empty, the loop does not execute, and the program prints:
     * "No integer found smaller than the target."
     * 
     * 9. Array Contains Only Negative Elements:
     * • If the array contains only negative elements, the program prints:
     * "No integer found smaller than the target."
     * 
     * 10. Target is Negative:
     * • If the target is negative, the program prints:
     * "No integer found smaller than the target."
     * 
     * 11. Target is Zero:
     * • If the target is zero, the program prints:
     * "No integer found smaller than the target."
     * 
     * 12. Target is Positive:
     * • If the target is positive, the program prints:
     * "No integer found smaller than the target."
     * 
     * 13. Array Contains Duplicate Elements:
     * • If the array contains duplicate elements, the largest element smaller than
     * the target will be the largest unique element in the array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     * 
     * 14. Array Contains Both Positive and Negative Elements:
     * • If the array contains both positive and negative elements, the largest
     * element smaller than the target will be the largest positive element in the
     * array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     * 
     * 15. Array Contains Both Zero and Positive Elements:
     * • If the array contains both zero and positive elements, the largest element
     * smaller than the target will be the largest positive element in the array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     * 
     * 16. Array Contains Both Zero and Negative Elements:
     * • If the array contains both zero and negative elements, the program prints:
     * "No integer found smaller than the target."
     * 
     * 17. Array Contains Zero and Negative Elements:
     * • If the array contains zero and negative elements, the largest element
     * smaller than the target will be the largest positive element in the array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     * 
     * 18. Array Contains Zero and Positive Elements:
     * • If the array contains zero and positive elements, the largest element
     * smaller than the target will be the largest positive element in the array.
     * • In this case, the program will print:
     * "Largest integer smaller than target: 20"
     */

}