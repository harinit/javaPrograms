package regular.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListToSet {
    public static void main(String[] args) {
        // Write a Java program to convert a List to a Set using the Java Stream API.
        // List with duplicates

        List<String> list = Arrays.asList("apple", "banana", "mango", "kiwi", "apple", "mango", "orange");

        // ✅ Convert List to Set (removes duplicates)
        Set<String> uniqueSet = list.stream()
                .collect(Collectors.toSet());

        System.out.println("Unique elements: " + uniqueSet);

        // ✅ Convert Set to List
        List<String> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("Converted back to List: " + uniqueList);

        // ✅ Remove duplicates from List using Java 8 Streams
        List<String> deduplicatedList = list.stream()
                .distinct() // Removes duplicates
                .collect(Collectors.toList());
        System.out.println("List after removing duplicates: " + deduplicatedList);

        // ✅ Keep the original list unchanged and create a unique Set when needed
        Set<String> uniqueSet1 = new HashSet<>(list);
        System.out.println("Unique elements (Set): " + uniqueSet1);

        // ✅ Convert Set back to List (but original list remains unchanged)
        List<String> uniqueList1 = new ArrayList<>(uniqueSet1);
        System.out.println("Unique List: " + uniqueList1);

        // ✅ Original list remains unchanged
        System.out.println("Original List (with duplicates): " + list);

        /*
         * Approach 2: Maintain Order While Removing Duplicates
         * 
         * If you need a unique list but still retain the original list, use
         * LinkedHashSet to maintain insertion order.
         */
        List<String> uniqueListOrdered = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("Unique List (Ordered): " + uniqueListOrdered);

        /*
         * Approach 3: Count Duplicates Without Modifying the List
         * 
         * If you want to count occurrences of each item while keeping the original
         * list:
         */
        Map<String, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println("Element Frequency: " + frequencyMap);
    }

}
