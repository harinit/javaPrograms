package gliderai;

import java.util.Arrays;

public class ThreeLittlePigs {
    
    public static int countWaysToDivide(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; // Need at least 3 elements for a valid partition

        int totalSum = Arrays.stream(arr).sum();

        if (totalSum % 3 != 0) return 0; // If not divisible by 3, impossible to divide

        int oneThird = totalSum / 3;
        int twoThirds = 2 * oneThird;

        int prefixSum = 0, countOneThird = 0, ways = 0;

        for (int i = 0; i < n - 1; i++) { // Ensure at least one element remains for last partition
            prefixSum += arr[i];

            // When prefixSum reaches two-thirds, count previous one-third partitions
            if (prefixSum == twoThirds) {
                ways += countOneThird;
            }

            // Count the number of times one-third appears
            if (prefixSum == oneThird) {
                countOneThird++;
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {3, 3, 3, 3},   // Expected output: 1
            {1, 1, 1},       // Expected output: 1
            {1, 2, 3, 0, 3}, // Expected output: 1
            {1, 1},          // Expected output: 0
            {0, 0, 0, 0, 0}  // Expected output: 10
        };

        for (int[] testCase : testCases) {
            System.out.println("Output for " + Arrays.toString(testCase) + " : " + countWaysToDivide(testCase));
        }
    }
}