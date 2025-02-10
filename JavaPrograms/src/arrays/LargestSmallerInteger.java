package arrays;

import java.util.Arrays;

public class LargestSmallerInteger {
    public static void main(String[] args) {
        // Test cases
        testFindLargestSmaller(new int[] { 1, 2, 3, 4 }, 4); // Output: 3
        testFindLargestSmaller(new int[] { -5, -4, -3, -2 }, 4); // Output: -2
        testFindLargestSmaller(new int[] { 1, 2, 3, 4 }, 1); // Output: null
        testFindLargestSmaller(new int[] {}, 4); // Output: Exception
        testFindLargestSmaller(null, 4); // Output: Exception
        testFindLargestSmaller(new int[] { -10, -5, 0, 5 }, -5); // Output: -10
    }

    /**
     * Finds the largest integer in a sorted array that is smaller than the given
     * target.
     *
     * @param sortedArray a sorted array of integers
     * @param target      the target integer
     * @return the largest integer smaller than the target, or null if no such
     *         integer exists
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static Integer findLargestSmaller(int[] sortedArray, int target) {
        // Validate input
        if (sortedArray == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (sortedArray.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }

        // Binary search for efficiency
        int left = 0, right = sortedArray.length - 1;
        Integer result = null;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] < target) {
                result = sortedArray[mid]; // Update result to the current value
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return result;
    }

    /**
     * Helper method to test the function with various inputs.
     *
     * @param sortedArray a sorted array of integers
     * @param target      the target integer
     */
    public static void testFindLargestSmaller(int[] sortedArray, int target) {
        System.out.println("Input Array: " + Arrays.toString(sortedArray));
        System.out.println("Target: " + target);

        try {
            Integer result = findLargestSmaller(sortedArray, target);
            System.out.println("Largest Smaller Integer: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}