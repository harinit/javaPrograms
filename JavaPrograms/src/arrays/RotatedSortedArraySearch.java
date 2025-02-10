package   arrays;


/* A rotated sorted array is an array of numbers sorted in ascending order, in which a portion of the array is 
moved from the beginning to the end. For example, a possible rotation of [1, 2, 3, 4, 5] is [3, 4, 5, 1, 2] , 
where the first two numbers are moved to the end.

Given a rotated sorted array of unique numbers, return the index of a target value. If the target value is not present, return -1.

Example:
Input: nums = [8, 9, 1, 2, 3, 4, 5, 6, 7], target = 1
Output: 2 */


import java.util.Arrays;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        // Test cases
        testSearchInRotatedArray(new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 1);   // Output: 2
        testSearchInRotatedArray(new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 6);   // Output: 7
        testSearchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);         // Output: 4
        testSearchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);         // Output: -1
        testSearchInRotatedArray(new int[]{1}, 1);                           // Edge case: single element, Output: 0
        testSearchInRotatedArray(new int[]{1}, 2);                           // Edge case: single element not found, Output: -1
        testSearchInRotatedArray(new int[]{}, 1);                            // Edge case: empty array, Output: Exception
        testSearchInRotatedArray(null, 1);                                   // Edge case: null array, Output: Exception
    }

    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param nums   The rotated sorted array.
     * @param target The target value to search for.
     * @return The index of the target value, or -1 if not found.
     * @throws IllegalArgumentException If the input array is null or empty.
     */
    public static int searchInRotatedArray(int[] nums, int target) {
        // Validate input
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        return -1; // Target not found
    }

    /**
     * Helper method to test the search function with various inputs.
     *
     * @param nums   The rotated sorted array.
     * @param target The target value.
     */
    public static void testSearchInRotatedArray(int[] nums, int target) {
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);

        try {
            int result = searchInRotatedArray(nums, target);
            System.out.println("Index of Target: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}

/* Edge Cases
	1.	Null Array:
	•	Throws IllegalArgumentException with a clear message.
	2.	Empty Array:
	•	Throws IllegalArgumentException with a clear message.
	3.	Single Element:
	•	Handles arrays with a single element.
	•	Returns 0 if the target is the single element; otherwise, -1.
	4.	Target Not Found:
	•	Returns -1 if the target value is not in the array.
	5.	Array Fully Sorted Without Rotation:
	•	The algorithm still works seamlessly. 
    
Approach
	1.	Binary Search:
	•	This approach works by determining which half of the array (left or right) is sorted at every iteration.
	•	Depending on the position of the target relative to the sorted half, the search space is reduced accordingly.

Steps
	1.	Identify Sorted Half:
	•	If nums[left] <= nums[mid], the left half is sorted.
	•	Otherwise, the right half is sorted.
	2.	Target in Sorted Half:
	•	If the target lies within the range of the sorted half, reduce the search space to that half.
	•	Otherwise, search in the other half.
	3.	Repeat:
	•	Continue this process until the target is found or the search space is empty.

Time Complexity
	•	O(log n): Binary search ensures that the search space is halved at each iteration.

Space Complexity
	•	O(1): No extra space is used apart from a few variables.
    
    */