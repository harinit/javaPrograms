package javaStrings;

import java.util.stream.IntStream;

public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        String reverseStr = new StringBuilder(str).reverse().toString();

        System.out.println("Is the string a palindrome? " + str.equalsIgnoreCase(reverseStr));

        // Using simple loop
        if(str.equalsIgnoreCase(reverseStr)) {
            System.out.println("The string is a palindrome");
        } else {
            System.out.println("The string is not a palindrome");
        }

        boolean isPalindrome = true;
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome) {
            System.out.println("The string is a palindrome");
        } else {
            System.out.println("The string is not a palindrome");
        }
        // Using Java 8

        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase(); // Normalize input

             IntStream.range(0, cleanedStr.length() / 2)
                .allMatch(i -> cleanedStr.charAt(i) == cleanedStr.charAt(cleanedStr.length() - 1 - i));

                System.out.println(str + " is palindrome " );

        
    }
}
