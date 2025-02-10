package regular.streams;

import java.util.*;
import java.util.stream.*;
// Write a Java program to join all elements in a List into a single String, separated by a given delimiter.
public class JoinWords {
    public static void main(String[] args) {
        //List<String> words = new ArrayList<String>();

        List<String> words = Arrays.asList("apple", "banana", "mango", "kiwi", "strawberry", "blueberryy", "orange");
        String result = words.stream().collect(Collectors.joining(" "));
        System.out.println(result); // Output: apple banana mango kiwi strawberry blueberryy orange
    }
}
