package gliderai;

public class ThreeLittlePigs1 {
    // public static int countWaysToDivide(int[] arr) {
    //     int n = arr.length;
    //     if (n < 3) return 0; // Need at least 3 elements to divide

    //     int totalSum = 0;
    //     for (int num : arr) totalSum += num;

    //     if (totalSum % 3 != 0) return 0; // Cannot split into three equal parts

    //     int oneThird = totalSum / 3;
    //     int twoThirds = 2 * oneThird;

    //     int ways = 0;
    //     int prefixSum = 0;
    //     int countOneThird = 0;

    //     for (int i = 0; i < n - 1; i++) { // Ensure at least one element remains for last partition
    //         prefixSum += arr[i];

    //         if (prefixSum == twoThirds) {
    //             ways += countOneThird; // Valid second partition found
    //         }
    //         if (prefixSum == oneThird) {
    //             countOneThird++; // Count occurrences of one-third partition
    //         }
    //     }

    //     return ways;
    // }


    public static int countWaysToDivide(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; // Need at least 3 elements

        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if (totalSum % 3 != 0) return 0; // Cannot split into three equal parts

        int oneThird = totalSum / 3;
        int twoThirds = 2 * oneThird;

        int prefixSum = 0, countOneThird = 0, ways = 0;

        for (int i = 0; i < n - 1; i++) { // Ensure at least one element remains for last partition
            prefixSum += arr[i];

            // When prefixSum is equal to two-thirds, count previous one-third partitions
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
        int[] arr1 = {-2, 4, 2, 1, 1};  // Example input
        System.out.println(countWaysToDivide(arr1)); // Output: 1

        int[] arr2 = {4, 3};  // Example input with only 2 elements
        System.out.println(countWaysToDivide(arr2)); // Output: 0

        System.out.println("***"); // More test cases
        int[][] testCases = {
            {3, 3, 3, 3},   // Expected output: 1
            {1, 1, 1},       // Expected output: 1
            {1, 2, 3, 0, 3}, // Expected output: 1
            {1, 1},          // Expected output: 0
            {0, 0, 0, 0, 0}  // Expected output: 10
        };

        for (int[] testCase : testCases) {
            System.out.println("Output for " + java.util.Arrays.toString(testCase) + " : " + countWaysToDivide(testCase));
        }
    }
}
