package leetcode.strings;

import java.util.Set;

/* 345. Reverse Vowels of a String
Easy
Topics
Companies
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters. 


	•	Two-pointer approach efficiently reverses vowels in O(n) time.
	•	Modifies the string in-place, using only O(1) extra space.
	•	Handles uppercase and lowercase vowels.
	•	Edge cases are covered.

*/
public class ReverseVowels {
    public static String reverseVowels(String s) {
        // Define the vowels (both lowercase and uppercase)
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        // Convert string to char array for in-place modification
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Move left pointer until it finds a vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right pointer until it finds a vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            // Swap vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm")); // Output: "AceCreIm"
        System.out.println(reverseVowels("leetcode")); // Output: "leotcede"
        System.out.println(reverseVowels("hello")); // Output: "holle"
        System.out.println(reverseVowels("aA")); // Output: "Aa"
        System.out.println(reverseVowels("a")); // Output: "a"
        System.out.println(reverseVowels("")); // Output: 
        System.out.println(reverseVowels("ApPlE")); // Output: "EpPlE"
        System.out.println(reverseVowels("aeiou")); // Output: "uoiea"
        System.out.println(reverseVowels("bcdfg")); // Output: "bcdfg"
    }

}
