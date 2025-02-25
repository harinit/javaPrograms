package leetcode.strings;

/* 242. Valid Anagram
Solved
Easy
Topics
Companies
Given two strings s and t, return true if t is an 
anagram
 of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // If lengths are different, not an anagram
        if (s.length() != t.length()) return false;

        // Character frequency array for 'a' to 'z' (26 letters)
        int[] charCount = new int[26];

        // Update character counts
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++; // Increment for s
            charCount[t.charAt(i) - 'a']--; // Decrement for t
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car")); // false
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("hello", "oellh")); // true
        System.out.println(isAnagram("abcd", "abce")); // false
    }
}