package leetcode.strings;

import java.util.stream.IntStream;

/* 
 * Leetcode: 344. Reverse String
 * 
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * 
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
// Time Complexity: O(n)
// Space Complexity: O(1)
public class ReverseString {
    public void reverseString(char[] s) {
       
        int left = 0, right = s.length - 1;
        if(left >= right) return;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move pointers
            left++;
            right--;
        }
    }

    // Using Java 8 Streams
    public void reverseStringUsingJava8(char[] s) {
        IntStream.range(0, s.length / 2).forEach(i -> {
            int j = s.length - 1 - i;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        });
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
        solution.reverseString(s1);
        System.out.println(s1); // Output: ["o","l","l","e","h"]

        char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        solution.reverseString(s2);
        System.out.println(s2); // Output: ["h","a","n","n","a","H"]
    }
}
