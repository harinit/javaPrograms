package strings;

public class CountLettersInString {
    public static int countLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    public static long countLettersStream(String str) {
        return str.chars()
                .filter(Character::isLetter)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(countLetters("Hello, World 123!")); // Output: 10
        System.out.println(countLettersStream("Hello, World 123!")); // Output: 10
        System.out.println(countLettersStream("Hello, Harini! this is a program to count letters in a string")); // Output: 48
    }

}
