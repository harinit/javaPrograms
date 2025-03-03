package arrays;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntSummaryStatisticsExample {
    public static void main(String[] args) {
        int[] numbers = { 7, 2, 9, 1, 5 };

        // Using IntSummaryStatistics
        IntSummaryStatistics stats = Arrays.stream(numbers).summaryStatistics();

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Count: " + stats.getCount()); // Total elements

        int minValue = stats.getMin();

        if (stats.getCount() == 0) {
            System.out.println("Array is empty, no valid statistics.");
        } else {
            System.out.println("Sum: " + stats.getSum()); // Sum of elements
            System.out.println("Minimum: " + stats.getMin()); // Minimum value
            System.out.println("Maximum: " + stats.getMax()); // Maximum value
            System.out.println("Average: " + stats.getAverage());
            System.out.println("Max Value : " + minValue); // Average of values
        }

        // Step 1: Create an Empty IntStream
        IntSummaryStatistics statsis = IntStream.empty().summaryStatistics();

        // Step 2: Print Default Values
        System.out.println("Minimum Value (getMin()): " + statsis.getMin());
        System.out.println("Maximum Value (getMax()): " + statsis.getMax());
        System.out.println("Sum (getSum()): " + statsis.getSum());
        System.out.println("Average (getAverage()): " + statsis.getAverage());
        System.out.println("Count (getCount()): " + statsis.getCount());

        // Minimum Value (getMin()): 2147483647
        // Maximum Value (getMax()): -2147483648
    }
}