package arrays;

import java.util.Arrays;

public class MergeSortSolution {
    public static void main(String[] args) {
        // Test cases
        testMergeSort(new int[]{6, 8, 4, 2, 7, 3, 1, 5}); // Output: [1, 2, 3, 4, 5, 6, 7, 8]
        testMergeSort(new int[]{10, -5, 0, 3, 2});        // Output: [-5, 0, 2, 3, 10]
        testMergeSort(new int[]{1});                      // Edge case: Single element, Output: [1]
        testMergeSort(new int[]{});                       // Edge case: Empty array, Exception
        testMergeSort(null);                              // Edge case: Null array, Exception
    }

    /**
     * Sorts the given integer array in ascending order using merge sort.
     *
     * @param nums The integer array to be sorted.
     * @return The sorted integer array.
     * @throws IllegalArgumentException If the input array is null or empty.
     */
    public static int[] mergeSort(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }

        // Call the recursive merge sort function
        mergeSortRecursive(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSortRecursive(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively divide the array
            mergeSortRecursive(nums, left, mid);
            mergeSortRecursive(nums, mid + 1, right);

            // Merge the sorted subarrays
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(nums, left, leftArray, 0, n1);
        System.arraycopy(nums, mid + 1, rightArray, 0, n2);

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            nums[k++] = leftArray[i++];
        }
        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }

    /**
     * Helper method to test the function with various inputs.
     *
     * @param nums The integer array to be sorted.
     */
    public static void testMergeSort(int[] nums) {
        System.out.println("Input Array: " + Arrays.toString(nums));

        try {
            int[] result = mergeSort(nums);
            System.out.println("Sorted Array (Merge Sort): " + Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}