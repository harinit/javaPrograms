package leetcode.arrays;

import java.util.stream.IntStream;

/* 941. Valid Mountain Array
Easy
Topics
Companies
Hint
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104 

4. Approach Explanation

Approach: Two Pointers (O(n) time)
	1.	Start with two pointers:
	•	left = 0 → Move uphill while arr[left] < arr[left + 1].
	•	right = arr.length - 1 → Move downhill while arr[right] < arr[right - 1].
	2.	A valid mountain array must satisfy:
	•	left == right → Peak must be the same from both ends.
	•	left != 0 && right != arr.length - 1 → Peak cannot be the first or last element.

Time Complexity:
	•	O(n) → We scan the array at most twice (one uphill, one downhill).

Space Complexity:
	•	O(1) → No extra memory is used.
    */
public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false; // A mountain must have at least 3 elements
        
        int left = 0, right = n - 1;

        // Move up the left side
        while (left + 1 < n && arr[left] < arr[left + 1]) {
            left++;
        }

        // Move down the right side
        while (right > 0 && arr[right - 1] > arr[right]) {
            right--;
        }

        // The peak must be the same point and cannot be first or last element
        return left == right && left > 0 && right < n - 1;
    }

    public boolean validMountainArrayUsingJava8(int[] arr) {
        int n = arr.length;
        if (n < 3) return false; // A mountain must have at least 3 elements

        // Find the peak index using streams
        @SuppressWarnings("unused")
        int peak = IntStream.range(0, n - 1)
                .filter(i -> arr[i] < arr[i + 1]) // Move up
                .reduce((first, second) -> second) // Get the last increasing index
                .orElse(-1);

        // If no increasing sequence or peak is at the start/end, return false
        if (peak <= 0 || peak >= n - 1) return false;

        // Check if the remaining part is strictly decreasing
        boolean isDecreasing = IntStream.range(peak, n - 1)
                .allMatch(i -> arr[i] > arr[i + 1]); // Move down

        return isDecreasing;
    }
    public static void main(String[] args) {
        ValidMountainArray solution = new ValidMountainArray();

        int[] arr1 = {2, 1};
        System.out.println(solution.validMountainArray(arr1)); // Output: false

        int[] arr2 = {3, 5, 5};
        System.out.println(solution.validMountainArray(arr2)); // Output: false

        int[] arr3 = {0, 3, 2, 1};
        System.out.println(solution.validMountainArray(arr3)); // Output: true

        int[] arr4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(solution.validMountainArray(arr4)); // Output: false

        int[] arr5 = {1,2,2,3,2,1};
        System.out.println(solution.validMountainArrayUsingJava8(arr5)); // Output: false
        //The peak must be strictly increasing, but arr[1] == arr[2].

        int[] arr6 = {1,2,3,2,1};
        System.out.println(solution.validMountainArray(arr6)); // Output: true
    }
    
}
