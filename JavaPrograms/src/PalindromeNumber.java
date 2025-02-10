public class PalindromeNumber {

    public static void main(String[] args) {
        // Simple Palindrome Check (Using Integer Arithmetic)
        int number = 121;
        boolean isPalindrome = isPalindromeNumber(number);
        System.out.println("Is " + number + " a palindrome? " + isPalindrome);

        // Using String Conversion
        int number1 = 12321;
        boolean isPalindrome1 = isPalindromeNumber1(number1);
        System.out.println("Is " + number1 + " a palindrome? " + isPalindrome1);

        // Recursive Palindrome Check
        int number2 = 1221;
        boolean isPalindrome2 = isPalindromeNumber2(number2);
        System.out.println("Is " + number2 + " a palindrome? " + isPalindrome2);
    }

    public static boolean isPalindromeNumber(int number) {
        // Negative numbers are not palindromes
        if (number < 0) {
            return false;
        }

        int original = number; // Save the original number
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10; // Extract the last digit
            reversed = reversed * 10 + digit; // Append the digit to reversed
            number /= 10; // Remove the last digit
        }

        return original == reversed;
    }

    // Using String Conversion
    public static boolean isPalindromeNumber1(int number1) {
        String numStr = Integer.toString(number1);
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedStr);
    }

    // Recursive Palindrome Check
    public static boolean isPalindromeNumber2(int number2) {
        return number2 == reverseNumber(number2, 0);
    }

    private static int reverseNumber(int number2, int reversed) {
        if (number2 == 0) {
            return reversed;
        }
        return reverseNumber(number2 / 10, reversed * 10 + number2 % 10);
    }
}

/*
 * 1. Arithmetic Approach:
 * • Time Complexity: O(log₁₀(n)) (Number of digits in the number)
 * • Space Complexity: O(1)
 * 2. String Conversion:
 * • Time Complexity: O(n) (n is the number of digits)
 * • Space Complexity: O(n) (for string conversion and reversal)
 * 3. Recursive Approach:
 * • Time Complexity: O(log₁₀(n))
 * • Space Complexity: O(log₁₀(n)) (recursion stack)
 */