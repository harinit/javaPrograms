package practice;

import java.util.Optional;

public class CountDigits {
    public static int countDigits(Optional<Integer> num) {
        return num.map(n -> String.valueOf(Math.abs(n)).length()).orElse(0);
    }

    public static int countDigitsWithNull(Integer num) {
        return Optional.ofNullable(num)
                .map(n -> String.valueOf(Math.abs(n)).length())
                .orElse(0);
    }

    // Method to count the number of digits in a given number string
    public static int countDigits(String numStr) {
        return Optional.ofNullable(numStr)
                       .filter(s -> !s.isEmpty() && s.matches("-?\\d+")) // Validate number format // Only allow valid integer numbers
                       //.map(s -> s.replace("-", ""))    // Remove negative sign if present
                       //.map(String::length)
                        //.orElse(0);
                       .map(s -> String.valueOf(Math.abs(Integer.parseInt(s))).length())
                       .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(countDigits(Optional.of(12345)));   // Output: 5
        System.out.println(countDigits(Optional.of(-9876)));   // Output: 4
        System.out.println(countDigits(Optional.of(0)));       // Output: 1
        System.out.println(countDigits(Optional.empty()));     // Output: 0
        System.out.println(countDigits(""));              // Output: 0
        System.out.println(countDigits("12345"));          // Output: 5
        System.out.println(countDigits("-98-76"));          // Output: 4
        System.out.println(countDigitsWithNull(0)); // Output: 1
        System.out.println(countDigitsWithNull(null)); // Output: 0
    }
}
