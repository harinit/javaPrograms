package arrays;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;

public class MaxMinArray {

    /*
     * Initialize variables max and min with the first element of the array.
     * Iterate through each element in the array.
     * If the current element is greater than max, update max.
     * If the current element is less than min, update min.
     * Print the final values of max and min.
     */
    public static void main(String[] args) {
        int[] numbers = { 7, 2, 9, 1, 5 };
        int max = numbers[0];
        int min = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        // Java 8 Stream API - Start

        // Example array
        int[] numbersArray = { 7, 2, 9, 1, 5 };
        findAndPrintMinMax(numbersArray);

        // Edge cases
        int[] emptyArray = {}; // Empty array
        findAndPrintMinMax(emptyArray);

        int[] allSameNumbers = { 4, 4, 4, 4 }; // All elements are the same
        findAndPrintMinMax(allSameNumbers);

        int[] negativeNumbers = { -3, -7, -1, -10 }; // All negative numbers
        findAndPrintMinMax(negativeNumbers);

        // Java 17 code
        // Example arrays
        int[] numbers1 = { 7, 2, 9, 1, 5 };
        int[] emptyArray1 = {};
        int[] allSameNumbers1 = { 4, 4, 4, 4 };
        int[] negativeNumbers1 = { -3, -7, -1, -10 };

        // Process each array
        processArray(numbers1, "Example Array");
        processArray(emptyArray1, "Empty Array");
        processArray(allSameNumbers1, "Array with All Same Numbers");
        processArray(negativeNumbers1, "Array with Negative Numbers");
    }

    private static void findAndPrintMinMax(int[] numbers) {
        // Use Java Streams to find min and max
        OptionalInt max = Arrays.stream(numbers).max();
        OptionalInt min = Arrays.stream(numbers).min();

        // Print results
        System.out.println("Array: " + Arrays.toString(numbers));
        if (numbers.length == 0) {
            System.out.println("The array is empty, no min or max values.\n");
        } else {
            System.out
                    .println("Maximum: " + max.orElseThrow(() -> new IllegalStateException("Unexpected empty array")));
            System.out
                    .println("Minimum: " + min.orElseThrow(() -> new IllegalStateException("Unexpected empty array")));
            System.out.println();
        }

    }

    // Java 8 Stream API - Completed

    // Java 17 code - start
    private static void processArray(int[] numbers, String arrayName) {
        System.out.println(arrayName + ": " + Arrays.toString(numbers));

        // Using Streams to find min and max
        try {
            OptionalInt max = Arrays.stream(numbers).max();
            OptionalInt min = Arrays.stream(numbers).min();

            if (numbers.length == 0) {
                throw new IllegalArgumentException("Array is empty, no minimum or maximum value.");
            }

            System.out.println("Maximum (Stream): " + max.orElseThrow());
            System.out.println("Minimum (Stream): " + min.orElseThrow());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Using IntSummaryStatistics (Another approach)
        try {
            IntSummaryStatistics stats = Arrays.stream(numbers).summaryStatistics();

            if (numbers.length == 0) {
                throw new IllegalArgumentException("Array is empty, statistics cannot be calculated.");
            }

            System.out.println("Maximum (Statistics): " + stats.getMax());
            System.out.println("Minimum (Statistics): " + stats.getMin());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
    // Java 17 code - end

    // Example Outputs:

    /*
     * Example Array: {7, 2, 9, 1, 5}
     * Example Array: [7, 2, 9, 1, 5]
     * Maximum (Stream): 9
     * Minimum (Stream): 1
     * Maximum (Statistics): 9
     * Minimum (Statistics): 1
     * 
     * Empty Array: []
     * Array is empty, no minimum or maximum value.
     * Array is empty, statistics cannot be calculated.
     * 
     * Array with All Same Numbers: [4, 4, 4, 4]
     * Array with All Same Numbers: [4, 4, 4, 4]
     * Maximum (Stream): 4
     * Minimum (Stream): 4
     * Maximum (Statistics): 4
     * Minimum (Statistics): 4
     * 
     * Array with Negative Numbers: [-3, -7, -1, -10]
     * Maximum (Stream): -1
     * Minimum (Stream): -10
     * Maximum (Statistics): -1
     * Minimum (Statistics): -10
     */
}
