package regular.streams;

import java.util.*;
import java.util.stream.Collectors;

/* Given a list of strings, write a Java program using streams to find the longest word in the list. */
public class LongestWord {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "mango", "kiwi", "strawberry", "blueberryy", "orange");
        Optional<String> longestWord = words.stream()   //Optional.ofNullable(words..)
                .max(Comparator.comparingInt(String::length)); //Finds the element in the stream with the maximum length, which in this case is the longest word.
                //.orElse(null));

                // words.set(0, null);  // ✅ Works: Replacing "apple" with null

                // System.out.println("Replaced Apple with Null ==> " +words);

                longestWord.ifPresent(word -> System.out.println("Longest word: " + word));


    // Step 1: Find the max length of words
        OptionalInt maxLength = words.stream()
                .mapToInt(String::length)
                .max();

        // Step 2: Filter and print all words with the max length
        maxLength.ifPresent(len -> {
            List<String> longestWords = words.stream()
                    .filter(word -> word.length() == len)
                    .collect(Collectors.toList());

            System.out.println("Longest words: " + longestWords);
        });

        // To add null to the end of the list
        List<String> wordsWithNullList = new ArrayList<>(Arrays.asList("apple", "banana", "mango", "kiwi", "strawberry", "blueberryy", "orange"));
        
        wordsWithNullList.add(null);  // ✅ Works fine

        System.out.println(wordsWithNullList);

        wordsWithNullList.set(1, null);  // ✅ Works: Replacing "banana" with null

        System.out.println(wordsWithNullList);

        /* 🔹 Why Does Arrays.asList() Throw an Exception?
	•	Arrays.asList() returns a backed array list, meaning it wraps an array in a List.
	•	Since arrays have fixed size, modifying the structure (adding/removing elements) is not allowed.
	•	You can replace elements, but you cannot add or remove them. 

    words.set(1, null);  // ✅ Works: Replacing "banana" with null
    words.add("grape");  // ❌ Fails: UnsupportedOperationException
    words.remove("kiwi"); // ❌ Fails: UnsupportedOperationException
    
    Method	                                    Allows null?	        Allows Adding/Removing?
    Arrays.asList(...)	                            ✅ Yes	            ❌ No
    new ArrayList<>(Arrays.asList(...))         	✅ Yes	            ✅ Yes
    List.of(...) (Java 9+)	                        ❌ No	            ❌ No
    */
    }
}
