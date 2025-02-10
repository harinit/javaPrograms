package arrays;

import java.util.Arrays;

// time complexity (O(log(m*n))) and space complexity (O(1)).
// where m is the number of rows and n is the number of columns.

public class SearchInMatrixWalmart {
    public static void main(String[] args) {
        // Test cases
        testSearchInMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 3); // Output: true
        testSearchInMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 13); // Output: false
        testSearchInMatrix(new int[][] { {} }, 5); // Edge case: empty row
        testSearchInMatrix(new int[0][0], 5); // Edge case: empty matrix
        testSearchInMatrix(new int[][] { { 1 } }, 1); // Edge case: single element
        testSearchInMatrix(new int[][] { { 1 } }, 2); // Edge case: single element not present
    }

    /**
     * Searches for a target in a sorted matrix using binary search.
     *
     * @param matrix the m x n integer matrix
     * @param target the integer target to find
     * @return true if the target exists in the matrix, false otherwise
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Validate input
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty.");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Treat the matrix as a flattened sorted array and apply binary search
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent overflow
            int midValue = matrix[mid / cols][mid % cols]; // Map the 1D index back to 2D

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * Test helper to validate searchMatrix with various test cases.
     *
     * @param matrix the matrix to search
     * @param target the target to find
     */
    public static void testSearchInMatrix(int[][] matrix, int target) {
        System.out.println("Matrix: " + Arrays.deepToString(matrix));
        System.out.println("Target: " + target);

        try {
            boolean result = searchMatrix(matrix, target);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }

}

// Explanation

/*
 * 1. Binary Search on a Flattened Matrix
 * • The matrix is treated as a 1D sorted array, where:
 * • Index i maps to row i / cols and column i % cols.
 * • This allows us to apply binary search directly on the matrix.
 * • Time Complexity:
 * • Binary search takes O(\log(m \times n)), where m is the number of rows and
 * n is the number of columns.
 * • Space Complexity:
 * • Since no additional space is used, space complexity is O(1).
 * 
 * 2. Exception Handling
 * • The code throws an IllegalArgumentException if the matrix is:
 * • null (not initialized).
 * • Empty (0 rows or 0 columns).
 * 
 * 3. Key Logic
 * • Compute the middle index in the flattened 1D array: mid = left + (right -
 * left) / 2.
 * • Map the middle index to the 2D matrix:
 * • Row: mid / cols
 * • Column: mid % cols
 * • Compare the value at matrix[mid / cols][mid % cols] with the target:
 * • If equal, return true.
 * • If less, move left to mid + 1.
 * • If greater, move right to mid - 1.
 */