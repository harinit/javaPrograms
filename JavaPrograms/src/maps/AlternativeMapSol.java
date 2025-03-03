package maps;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlternativeMapSol {
    private static final Logger logger = Logger.getLogger(AlternativeMapSol.class.getName());

    public static void main(String[] args) {
        // Step 1: Define Lists (Contains null and empty values)
        List<Integer> integerList = Arrays.asList(101, 102, 103, null, 104, null);
        List<String> stringList = Arrays.asList("Apple", "Banana", null, "Cherry", "",""); // Contains null & empty string

        // Step 2: Wrap Lists in Optional to Avoid NullPointerException
        List<Integer> safeIntegerList = Optional.ofNullable(integerList).orElse(Collections.emptyList());
        List<String> safeStringList = Optional.ofNullable(stringList).orElse(Collections.emptyList());

        // Step 3: Remove Null and Empty Values from Lists
        List<String> filteredStringList = safeStringList.stream()
                .filter(Objects::nonNull) // ✅ Remove null values
                .filter(s -> !s.trim().isEmpty()) // ✅ Remove empty strings correctly
                .collect(Collectors.toList());

        List<Integer> filteredIntegerList = safeIntegerList.stream()
                .filter(Objects::nonNull) // ✅ Remove null values
                .collect(Collectors.toList());

        // Step 4: Log If Nulls or Empty Strings Were Found
        if (filteredStringList.size() < safeStringList.size()) {
            logger.warning("Null or empty values found in stringList, removed them before processing.");
        }

        if (filteredIntegerList.size() < safeIntegerList.size()) {
            logger.warning("Null values found in integerList, removed them before processing.");
        }

        // Step 5: Convert Lists to Map with Merge Function
        int minSize = Math.min(filteredIntegerList.size(), filteredStringList.size());
        @SuppressWarnings("unused")
        Map<String, Integer> stringIntegerMap = IntStream.range(0, minSize)
                .boxed()
                .collect(Collectors.toMap(
                        filteredStringList::get,
                        filteredIntegerList::get,
                        (existingValue, newValue) -> existingValue // ✅ Keeps first value, ignores duplicates
                ));

        // Step 6: Print the Final Map
        System.out.println("Final Map: " + stringIntegerMap);
    }

}
