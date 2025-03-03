package practice;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class MaxFactorialFinder {
    public static void main(String[] args) {
        int n = 1;
        while (true) {
            try {
                long startTime = System.nanoTime();
                // BigInteger factorial = calculateBigFactorial(n);
                long endTime = System.nanoTime();

                // Print Execution Time and Memory Usage
                long executionTime = (endTime - startTime) / 1_000_000; // Convert to ms
                long freeMemory = Runtime.getRuntime().freeMemory(); // Available memory in bytes

                System.out.println(n + "! computed in " + executionTime + " ms | Free Memory: " + (freeMemory / (1024 * 1024)) + " MB");

                //n++; // Increment and continue testing
            } catch (OutOfMemoryError e) {
                System.out.println("Max factorial reached before memory overflow: " + (n - 1) + "!");
                break;
            }
        }
    }

    public static BigInteger calculateBigFactorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

     public static BigInteger calculateFactorial(int n) {
        return (n == 0) ? BigInteger.ONE : 
            IntStream.rangeClosed(1, n)
                     .mapToObj(BigInteger::valueOf)
                     .reduce(BigInteger.ONE, BigInteger::multiply);
     }
} 

/* import java.math.BigInteger;
import java.util.stream.IntStream;

public class MaxFactorialFinder {
    public static void main(String[] args) {
        int n = 1;
        while (true) {
            try {
                long startTime = System.nanoTime();
                
                // Compute factorial
                BigInteger factorial = calculateBigFactorial(n);

                long endTime = System.nanoTime();
                long executionTime = (endTime - startTime) / 1_000_000; // Convert to ms
                long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024); // Convert to MB
                
                // Print factorial for small values, track time for large values
                if (n <= 20) {
                    System.out.println(n + "! = " + factorial);
                }

                System.out.println(n + "! computed in " + executionTime + " ms | Free Memory: " + freeMemory + " MB");

                // Stop when memory gets too low
                if (freeMemory < 50) {
                    System.out.println("Stopping due to low memory! Last computed factorial: " + n + "!");
                    break;
                }

                n++; // Increment n for the next iteration

            } catch (OutOfMemoryError e) {
                System.out.println("Max factorial reached before memory overflow: " + (n - 1) + "!");
                break;
            }
        }
    }

    public static BigInteger calculateBigFactorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
} */