package strings;

import java.util.*;
import java.util.stream.Gatherer.Integrator.Greedy;

/* Rearrange String such that no two same characters are adjacent to each other 
Java 17 solution with exceptions and edge cases
🔹 Final Comparison
Approach	                    Time Complexity	        Space Complexity	            Best For
Max Heap (PriorityQueue)	    O(N log K)	            O(N)	                        Best for smaller datasets
Sorting + Greedy	            O(N log N)	            O(N)	                        Good for moderate inputs
Counting Sort (Bucket-based)	O(N)	                O(N)	                        Best for large inputs

🔹 Summary
	•	Use Approach 3 (Counting Sort + Greedy) for O(N) performance.
	•	Use Approach 1 (Max Heap) if a PriorityQueue-based approach is required.
	•	Use Approach 2 (Sorting) for a simple and structured method.
    */
public class RearrangeString {
    /* Approach 3: Counting Sort (Bucket-based Greedy)

    Time Complexity: O(N), Space Complexity: O(N) */
    public static String rearrangeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxFreq = 0, maxChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = i;
            }
        }

        if (maxFreq > (s.length() + 1) / 2) return ""; // Impossible case

        char[] res = new char[s.length()];
        int index = 0;

        while (freq[maxChar] > 0) {
            res[index] = (char) (maxChar + 'a');
            index += 2;
            freq[maxChar]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (index >= s.length()) index = 1;
                res[index] = (char) (i + 'a');
                index += 2;
                freq[i]--;
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        List<String> testCases = List.of("aab", "aaab", "vvvlo", "aa", "abab", "aaaa", "aabbcc", "z");
        for (String test : testCases) {
            System.out.println("Input: " + test + " → Output: " + rearrangeString(test));
        }
    }
 /* ✅ Approach 2: Sorting + Greedy

Time Complexity: O(N log N), Space Complexity: O(N) */
/* public static String rearrangeString(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }

    int maxFreq = 0, maxChar = 0;
    for (int i = 0; i < 26; i++) {
        if (freq[i] > maxFreq) {
            maxFreq = freq[i];
            maxChar = i;
        }
    }

    if (maxFreq > (s.length() + 1) / 2) return ""; // Impossible case

    char[] res = new char[s.length()];
    int index = 0;

    while (freq[maxChar] > 0) {
        res[index] = (char) (maxChar + 'a');
        index += 2;
        freq[maxChar]--;
    }

    for (int i = 0; i < 26; i++) {
        while (freq[i] > 0) {
            if (index >= s.length()) index = 1;
            res[index] = (char) (i + 'a');
            index += 2;
            freq[i]--;
        }
    }

    return new String(res);
}

public static void main(String[] args) {
    List<String> testCases = List.of("aab", "aaab", "vvvlo", "aa", "abab", "aaaa", "aabbcc", "z");
    for (String test : testCases) {
        System.out.println("Input: " + test + " → Output: " + rearrangeString(test));
    }
} */


/* 

Edge Case	                        Input	        Expected Output	                                Explanation
All identical characters	        "aaaa"	        ""	                                            Cannot be rearranged.
Already alternating characters	    "abab"	        "abab"	                                        Already valid.
Characters with equal frequency	    "aabbcc"	    "abcabc"	                                    Multiple valid outputs.
Single character	                "a"	             "a"	                                        No adjacent characters to check.
Two different characters	        "ab"	         "ab"	                                        Already valid.
Two same characters only	        "aa"	          ""	                                        Cannot be rearranged.
Large input	                        "aabbccddeeffgghhii...zz"	"abcdefg...zabcdefg...z"	        Ensures O(N) complexity holds for large input.
Multiple dominant characters	    "vvvlo"	            "vlvvo"	                                    Must handle frequencies correctly.

✅ Approach 1: Max Heap (PriorityQueue)

Time Complexity: O(N log K), Space Complexity: O(N)
import java.util.*;

class RearrangeStringHeap {
    public static String rearrangeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder result = new StringBuilder();
        Queue<Character> waitQueue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            result.append(current);
            freqMap.put(current, freqMap.get(current) - 1);

            waitQueue.offer(current);
            if (waitQueue.size() > 1) {
                char ready = waitQueue.poll();
                if (freqMap.get(ready) > 0) {
                    maxHeap.offer(ready);
                }
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        List<String> testCases = List.of("aab", "aaab", "vvvlo", "aa", "abab", "aaaa", "aabbcc", "z");
        for (String test : testCases) {
            System.out.println("Input: " + test + " → Output: " + rearrangeString(test));
        }
    }
} */
}
