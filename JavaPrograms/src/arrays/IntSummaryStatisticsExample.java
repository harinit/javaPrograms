package arrays;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class IntSummaryStatisticsExample {
    public static void main(String[] args) {
        int[] numbers = {7, 2, 9, 1, 5};

        // Using IntSummaryStatistics
        IntSummaryStatistics stats = Arrays.stream(numbers).summaryStatistics();

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Count: " + stats.getCount());      // Total elements
        

        if (stats.getCount() == 0) {
            System.out.println("Array is empty, no valid statistics.");
        } else {
            System.out.println("Sum: " + stats.getSum());          // Sum of elements
            System.out.println("Minimum: " + stats.getMin());      // Minimum value
            System.out.println("Maximum: " + stats.getMax());      // Maximum value
            System.out.println("Average: " + stats.getAverage());  // Average of values
        }
    }
}