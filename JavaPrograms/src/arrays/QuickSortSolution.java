
package arrays;

import java.util.Arrays;

public class QuickSortSolution {
    public static void main(String[] args) {
        // Test cases
        testQuickSort(new int[]{6, 8, 4, 2, 7, 3, 1, 5}); // Output: [1, 2, 3, 4, 5, 6, 7, 8]
        testQuickSort(new int[]{10, -5, 0, 3, 2});        // Output: [-5, 0, 2, 3, 10]
        testQuickSort(new int[]{1});                      // Edge case: Single element, Output: [1]
        testQuickSort(new int[]{});                       // Edge case: Empty array, Exception
        testQuickSort(null);                              // Edge case: Null array, Exception
    }

    /**
     * Sorts the given integer array in ascending order using quick sort.
     *
     * @param nums The integer array to be sorted.
     * @return The sorted integer array.
     * @throws IllegalArgumentException If the input array is null or empty.
     */
    public static int[] quickSort(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }

        // Call the recursive quick sort function
        quickSortRecursive(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSortRecursive(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(nums, low, high);

            // Recursively sort the two halves
            quickSortRecursive(nums, low, partitionIndex - 1);
            quickSortRecursive(nums, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        // Swap the pivot element to its correct position
        swap(nums, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Helper method to test the function with various inputs.
     *
     * @param nums The integer array to be sorted.
     */
    public static void testQuickSort(int[] nums) {
        System.out.println("Input Array: " + Arrays.toString(nums));

        try {
            int[] result = quickSort(nums);
            System.out.println("Sorted Array (Quick Sort): " + Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}
/* 
Algorithm	Time Complexity	        Space Complexity	                                Best Use Case
Merge Sort	 O(n log n)	            O(n)	                                           Stable sort, better for large datasets or datasets that require stability.
Quick Sort	O(n log n)	            O(\log n)	                                        Faster in practice for small to medium-sized datasets, but not stable. */