package strings;


public class Palindrome {

    public static void main(String[] args) {
        // Simple Palindrome Check (Case-Sensitive)
        String input = "madam";
        boolean isPalindrome = isPalindrome(input);
        System.out.println("Is \"" + input + "\" a palindrome? " + isPalindrome);

        // Palindrome Check (Case-Insensitive, Ignore Spaces)
        String input1 = "A man a plan a canal Panama";
        boolean isPalindrome1 = isPalindromeIgnoreCase(input1);
        System.out.println("Is \"" + input1 + "\" a palindrome? " + isPalindrome1);

        // Using StringBuilder (Reversed String Comparison)
        String input2 = "RaceCar";
        boolean isPalindrome2 = isPalindromeWithStringBuilder(input2);
        System.out.println("Is \"" + input2 + "\" a palindrome? " + isPalindrome2);

        // Recursive Palindrome Check
        String input3 = "madam";
        boolean isPalindrome3 = isPalindromeRecursive(input.toLowerCase());
        System.out.println("Is \"" + input3 + "\" a palindrome? " + isPalindrome3);
    }

    // Simple Palindrome Check (Case-Sensitive)
    public static boolean isPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Palindrome Check (Case-Insensitive, Ignore Spaces)
    public static boolean isPalindromeIgnoreCase(String input1) {
        String sanitized = input1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = sanitized.length() - 1;
        while (left < right) {
            if (sanitized.charAt(left) != sanitized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Simple Palindrome Check (Case-Sensitive)
    public static boolean isPalindromeWithStringBuilder(String input2) {
        String sanitized = input2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(sanitized).reverse().toString();
        return sanitized.equals(reversed);
    }

    // Recursive Palindrome Check
    public static boolean isPalindromeRecursive(String input) {
        if (input.length() <= 1) {
            return true;
        }
        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(input.substring(1, input.length() - 1));
    }

    /*
     * 1. Iterative Approach:
     * • Time Complexity: O(n) (n is the length of the string)
     * • Space Complexity: O(1) (constant space)
     * 2. StringBuilder Approach:
     * • Time Complexity: O(n)
     * • Space Complexity: O(n) (for the reversed string)
     * 3. Recursive Approach:
     * • Time Complexity: O(n)
     * • Space Complexity: O(n) (stack space due to recursion)
     */
}
