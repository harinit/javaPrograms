package gliderai;

import java.util.HashMap;
import java.util.Map;

public class MagneticLetters {
    public static String solve(String S1, String S2, String R) {
        // Step 1: Create frequency maps for required and available characters
        Map<Character, Integer> freqRequired = new HashMap<>();
        Map<Character, Integer> freqAvailable = new HashMap<>();

        // Step 2: Count frequencies in S1 and S2
        for (char ch : S1.toCharArray()) {
            freqRequired.put(ch, freqRequired.getOrDefault(ch, 0) + 1);
        }
        for (char ch : S2.toCharArray()) {
            freqRequired.put(ch, freqRequired.getOrDefault(ch, 0) + 1);
        }

        // Step 3: Count frequencies in R (available letters)
        for (char ch : R.toCharArray()) {
            freqAvailable.put(ch, freqAvailable.getOrDefault(ch, 0) + 1);
        }

        // Step 4: Check if R has exactly the required letters (no extra, no less)
        if (freqRequired.size() != freqAvailable.size()) {
            return "No";  // If different number of unique characters, mismatch
        }

        // Step 5: Check if required letters are available in R
        for (char key : freqRequired.keySet()) {
            if (freqRequired.get(key) > freqAvailable.getOrDefault(key, 0)) {
                return "No"; // Case: Not enough letters to form S1 and S2
            }
        }

        // if (!freqAvailable.containsKey(key) || !freqRequired.get(key).equals(freqAvailable.get(key))) {
        //     return "No"; // Case: Not enough or extra letters
        // }

        return "Yes"; // Case: S1 and S2 can be constructed using all letters in R
    }

    public static void main(String[] args) {
        // Example Test Case
        String S1 = "SAM";
        String S2 = "JOHN";
        String R = "SAMJOHN";
        
        System.out.println(solve(S1, S2, R)); // Expected Output: Yes

        String S = "SAM";
        String S12 = "JOHN";
        String R1 = "SAMLJOHN";
        
        System.out.println(solve(S, S12, R1)); // Expected Output: NO
    }
}
