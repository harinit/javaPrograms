package arrays;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        // Test cases
        testSortArray(new int[]{6, 8, 4, 2, 7, 3, 1, 5}); // Output: [1, 2, 3, 4, 5, 6, 7, 8]
        testSortArray(new int[]{10, -5, 0, 3, 2});        // Output: [-5, 0, 2, 3, 10]
        testSortArray(new int[]{1});                      // Edge case: Single element, Output: [1]
        testSortArray(new int[]{});                       // Edge case: Empty array, Exception
        testSortArray(null);                              // Edge case: Null array, Exception ==> Input array cannot be null
    }

    /**
     * Sorts the given integer array in ascending order.
     *
     * @param nums The integer array to be sorted.
     * @return The sorted integer array.
     * @throws IllegalArgumentException If the input array is null or empty.
     */
    public static int[] sortArray(int[] nums) {
        // Validate input
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }

        // Sort the array
        Arrays.sort(nums);

        return nums;
    }

    /**
     * Helper method to test the function with various inputs.
     *
     * @param nums The integer array to be sorted.
     */
    public static void testSortArray(int[] nums) {
        System.out.println("Input Array: " + Arrays.toString(nums));

        try {
            int[] result = sortArray(nums);
            System.out.println("Sorted Array: " + Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}

/* Key Points
	1.	Input Validation:
	•	If the input array is null, an IllegalArgumentException is thrown.
	•	If the input array is empty, an IllegalArgumentException is thrown.
	2.	Sorting:
	•	The Arrays.sort(nums) method is used to sort the array in ascending order.
	•	This method is highly optimized and uses a variation of the Dual-Pivot Quicksort algorithm for primitive arrays, ensuring O(n \log n) performance.
	3.	Edge Case Handling:
	•	Null Array: Throws an exception.
	•	Empty Array: Throws an exception.
	•	Single Element Array: Returns the array as-is.
	•	Negative Numbers: Handles them seamlessly, sorting them in ascending order.
	•	Duplicates: Handles duplicate values correctly.
	4.	Output:
	•	Returns the sorted array, modifying the input array in place. */