package arrays;

import java.util.Arrays;

public class SumofArray {
    public static void main(String[] args) {
        int[] numbers1 = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for (int num : numbers1) {
            sum += num;
        }
        System.out.println("Sum of elements: " + sum);

        // Using Java 8 Stream API
        // Test with various arrays
        int[] numbers = {1, 2, 3, 4, 5}; // Example array
        calculateAndPrintSum(numbers);

        // Edge cases
        int[] emptyArray = {}; // Empty array
        calculateAndPrintSum(emptyArray);

        int[] negativeNumbers = {-1, -2, -3, -4, -5}; // All negative numbers
        calculateAndPrintSum(negativeNumbers);

        int[] mixedNumbers = {1, -1, 2, -2, 3, -3}; // Mixed positive and negative numbers
        calculateAndPrintSum(mixedNumbers);
    }

    private static void calculateAndPrintSum(int[] numbers) {
        // Use Java Streams for summing the elements
        int sum = Arrays.stream(numbers).sum();

        // Print the sum
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Sum of elements in Array: " + sum + "\n");
    }

    //Java 8 Stream API Completed

    //Additional Test Cases
    /* Array: [1, 2, 3, 4, 5]
    Sum of elements: 15

    Input: {} (Empty Array)
    Output: Array: []
    Sum of elements: 0 
    
     Input: {-1, -2, -3, -4, -5}
     Sum of elements: -15

    Input: {1, -1, 2, -2, 3, -3}
    Sum of elements: 2
    
    
    */
}
