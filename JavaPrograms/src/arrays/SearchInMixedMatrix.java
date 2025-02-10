package arrays;

import java.util.Arrays;

public class SearchInMixedMatrix {
    public static void main(String[] args) {
        // Test cases
        testSearchInMatrix(new Object[][] {
                { 1, "3", 5, 7 },
                { 10, "11", 16, "20" },
                { 23, 30, "34", 60 } }, "3"); // Output: true

        testSearchInMatrix(new Object[][] {
                { 1, "3", 5, 7 },
                { 10, "11", 16, "20" },
                { 23, 30, "34", 60 } }, 11); // Output: false

        testSearchInMatrix(new Object[][] {
                { 1, "3", 5, 7 },
                { 10, "11", 16, "20" },
                { 23, 30, "34", 60 } }, 16); // Output: true

        testSearchInMatrix(new Object[][] { {} }, "5"); // Edge case: empty row
        testSearchInMatrix(null, 5); // Edge case: null matrix
        testSearchInMatrix(new Object[][] { { "1" } }, "1"); // Edge case: single element as string
        testSearchInMatrix(new Object[][] { { 1 } }, 1); // Edge case: single element as integer
    }

    /**
     * Searches for a target in a mixed matrix (Strings and Integers).
     *
     * @param matrix the m x n matrix containing Objects
     * @param target the target to search for (Integer or String)
     * @return true if the target exists, false otherwise
     */
    public static boolean searchMixedMatrix(Object[][] matrix, Object target) {
        // Validate input
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty.");
        }

        // Iterate through the matrix
        for (Object[] row : matrix) {
            for (Object element : row) {
                // Check for type compatibility and equality
                if (element != null && element.equals(target)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Test helper to validate searchMixedMatrix with various test cases.
     *
     * @param matrix the matrix to search
     * @param target the target to find
     */
    public static void testSearchInMatrix(Object[][] matrix, Object target) {
        System.out.println("Matrix: " + Arrays.deepToString(matrix));
        System.out.println("Target: " + target);

        try {
            boolean result = searchMixedMatrix(matrix, target);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}


/* Explanation

1. Handling Mixed Data Types
	•	The matrix is defined as a 2D array of Object (Object[][]), which can store both String and Integer values.
	•	The target is also an Object, so it can handle both String and Integer comparisons.

2. Equality Check
	•	The equals method is used to compare the target with each element in the matrix. This works for both String and Integer types.
	•	null values are skipped, and elements of unsupported types (if any) are ignored.

3. Edge Case Handling
	•	The code throws an exception for null or empty matrices.
	•	Single-element matrices and mixed-type matrices are handled seamlessly. */