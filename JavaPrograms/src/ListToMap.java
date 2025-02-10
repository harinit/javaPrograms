import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "1","2");

        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(
                        String::length, // Key is the length of the string
                        str -> str, // Value is the string itself
                        (existing, replacement) -> {
                            System.out.println("Duplicate key detected: " + existing + " and " + replacement);
                            return existing; // Keep the existing value
                        }));

        System.out.println(map);

        // To return both existing & replacement
        // Create a Map where the key is the string length and the value is a List of
        // Strings
        Map<Integer, List<String>> mapforExistingReplacement = list.stream()
                .collect(Collectors.toMap(
                        String::length, // Key is the length of the string
                        str -> new ArrayList<>(Collections.singletonList(str)), // Initialize with the first value in a
                                                                                // list
                        (existing, replacement) -> {
                            existing.addAll(replacement); // Add the replacement to the existing list
                            return existing; // Return the updated list
                        }));

        // Map<Integer, String> map = list.stream()
        // .collect(Collectors.toMap(String::length, str -> str));

        System.out.println(mapforExistingReplacement);

        // Using a Set for Unique Values

        // If you want to avoid duplicates and store each value only once, you can use a
        // Set instead of a List. A Set will automatically handle duplicate entries.

        // Create a Map where the key is the string length and the value is a Set of Strings
        Map<Integer, Set<String>> mapToSetMap = list.stream()
            .collect(Collectors.toMap(
                String::length,           // Key is the length of the string
                str -> new HashSet<>(Collections.singletonList(str)), // Initialize with the first value in a Set
                (existing, replacement) -> { 
                    existing.addAll(replacement); // Add the replacement to the existing Set
                    return existing;  // Return the updated Set
                }
            ));
                System.out.println("maptoSetMap " +mapToSetMap);

                //map to list
                Map<Integer, List<String>> mapToList = list.stream()
                .collect(Collectors.groupingBy(
                    String::length, // Key is the length of the string
                    Collectors.toList() // Value is a List of strings
                ));
                System.out.println("mapToList " + mapToList);
    }
}
