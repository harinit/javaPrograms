package gliderai;

public class ParenthesesCorrection {
    public static int minInsertions(String S) {
        int openCount = 0; // Tracks unmatched '('
        int insertions = 0; // Tracks required insertions

        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                openCount++; // Increase '(' count
            } else { // ch == ')'
                if (openCount > 0) {
                    openCount--; // Match ')' with '('
                } else {
                    insertions++; // Need an extra '(' before ')'
                }
            }
        }

        // Any unmatched '(' needs closing ')'
        insertions += openCount;

        return insertions;
    }

    public static void main(String[] args) {
        String S = "()())";
        System.out.println(minInsertions(S)); // Output: 1

        String S1 = "()(())";
        System.out.println(minInsertions(S1)); // Output: 0

        String S2 = "(((";
        System.out.println(minInsertions(S2)); // Output: 3
    }
}
