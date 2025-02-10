package regular;

import java.util.stream.IntStream;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        System.out.println(isPrime(19));  // true
        System.out.println(isPrime(49));  // false
        System.out.println(isPrime(97));  // true
        System.out.println(isPrime(10000019)); // true (large prime)
        System.out.println(isPrime(10000000)); // false (large non-prime)
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Parallel stream to check divisibility from 5 to sqrt(n)
        return IntStream.rangeClosed(5, (int) Math.sqrt(n))
                .parallel() // Enable parallel execution
                .filter(i -> i % 2 != 0) // Skip even numbers
                .filter(i -> i % 3 != 0) // Skip multiples of 3
                .noneMatch(i -> n % i == 0); // If any divisor is found, return false
    }
}
