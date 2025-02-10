package regular.streams;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "programming", "is", "fun");

        Map<Integer, List<String>> groupedWords = words.stream().collect(Collectors.groupingBy(String::length));
        // Groups the words based on their length. The classifier function
        // String::length returns the length of each word, and the words are grouped
        // accordingly.
        System.out.println(groupedWords);

        groupedWords.forEach((length, wordsList) -> {
            System.out.println("Words of length " + length + ": " + wordsList);
        });
    }
}
