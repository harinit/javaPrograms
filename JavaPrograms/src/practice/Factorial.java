package practice;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {

        int number = 5;
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + number + " is: " + fact);

        int n = 12;
                int factorial = IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
        System.out.println("Factorial of " + number + " using Java 8 Streams is: " + factorial);

        // Using Recursion
        System.out.println("Factorial of " + number + " using recursion is: " + factorial(number));

        // Using Java 8 Streams
        System.out.println("Factorial of " + number + " using Java 8 Streams is: " + factorialUsingStreams(number));

        // Using Java 8 Parallel Streams
        System.out.println("Factorial of " + number + " using Java 8 Parallel Streams is: " + factorialUsingParallelStreams(number));

        // Using Java 8 Streams with custom parallelism
        System.out.println("Factorial of " + number + " using Java 8 Streams with custom parallelism is: " + factorialUsingParallelStreams(number, 10));

        // // Using Java 8 Streams with custom parallelism and custom reduction
        // System.out.println("Factorial of " + number + " using Java 8 Streams with custom parallelism and custom reduction is: " + factorialUsingParallelStreamsAndCustomReduction(number, 10));

        // // Using Java 8 Streams with custom parallelism and custom reduction
        // System.out.println("Factorial of " + number + " using Java 8 Streams with custom parallelism and custom reduction and parallelism level 10 is: " + factorialUsingParallelStreamsAndCustomReduction(number, 10, 10));

        
    }
    
    // Recursive method
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Java 8 Streams method
    public static long factorialUsingStreams(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply)
                .longValue();
    }

    // Java 8 Parallel Streams method
    public static long factorialUsingParallelStreams(int n) {
        return IntStream.rangeClosed(1, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply)
                .longValue();
    }

    // Java 8 Streams with custom parallelism
    public static long factorialUsingParallelStreams(int n, int parallelism) {
        return IntStream.rangeClosed(1, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply)
                .longValue();
    }

    // Java 8 Streams with custom parallelism and custom reduction
    // public static long factorialUsingParallelStreamsAndCustomReduction(int n, int parallelism, BiFunction<BigInteger, BigInteger, BigInteger> reductionFunction) {
    //     return IntStream.rangeClosed(1, n)
    //            .parallel()
    //            .mapToObj(BigInteger::valueOf)
    //            .reduce(BigInteger.ONE, reductionFunction);
    // }

    // Java 8 Streams with custom parallelism and custom reduction
    // public static long factorialUsingParallelStreamsAndCustomReduction(int n, int parallelism) {
    //     return factorialUsingParallelStreamsAndCustomReduction(n, parallelism, BigInteger::multiply);
    // }

    // Java 8 Streams with custom parallelism and custom reduction and parallelism level 10
    // public static long factorialUsingParallelStreamsAndCustomReduction(int n, int parallelism, int parallelismLevel) {
    //     return factorialUsingParallelStreamsAndCustomReduction(n, parallelism, parallelismLevel, BigInteger::multiply);
    // }

    // Java 8 Streams with custom parallelism and custom reduction and parallelism level 10
    // public static long factorialUsingParallelStreamsAndCustomReduction(int n, int parallelism, int parallelismLevel, BiFunction<BigInteger, BigInteger, BigInteger> reductionFunction) {
    //     return IntStream.rangeClosed(1, n)
    //            .parallel()
    //            .mapToObj(BigInteger::valueOf)
    //            .reduce(BigInteger.ONE, reductionFunction);
    // }


    
}



