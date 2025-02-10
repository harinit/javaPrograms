package regular.streams;

import java.util.*;
import java.util.stream.Collectors;

public class FlattenList {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList( Arrays.asList("John", "Jane"), Arrays.asList("Alice", "Bob"), Arrays.asList("Tom", "Jerry"));

        List<String> flattenedList = listOfLists.stream().flatMap(Collection::stream).toList();
        System.out.println(flattenedList); // Output: [John, Jane, Alice, Bob, Tom, Jerry]
        /* Key Points:
        •	flatMap(Collection::stream) → Extracts and flattens elements from each inner list.
        •	toList() (Java 16+) → Creates an unmodifiable list (cannot add/remove elements).
    
            Output Behavior:
        •	✅ More concise.
        •	🚫 Immutable (modifications like add() will throw UnsupportedOperationException). */

        List<String> flattenedList1 = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());  

            /* Key Points:
        •	flatMap(List::stream) → Same as Collection::stream, extracts elements.
        •	collect(Collectors.toList()) → Creates a mutable list (can add/remove elements).

    Output Behavior:
        •	✅ Mutable list (supports add() and remove()).
        •	✅ Works in Java 8+ (useful if Java 16+ is unavailable).
        •	⚠️ More verbose than .toList(). */
        flattenedList1.add("kiwi"); // ✅ Works fine
        flattenedList1.remove("Jane"); // ✅ Works fine
        //flattenedList1.clear(); // ✅ Works fine
        System.out.println(flattenedList1); // Output: [John, Jane, Alice, Bob, Tom, Jerry]
    }

}
