package maps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapWithNPE {
    public static void main(String[] args) {
        try {
            // Step 1: Define Two Lists (Handling Nulls)
            List<Integer> integerList = Arrays.asList(101, 102, 103);
            List<String> stringList = Arrays.asList("Apple", "Banana", null); // Contains null

            // Step 2: Validate Lists Before Processing
            if (integerList == null || stringList == null) {
                throw new NullPointerException("One of the lists is null!");
            }

            if (integerList.contains(null) || stringList.contains(null)) {
                throw new NullPointerException("List contains null values!");
            }

            // Step 3: Convert Lists to Map with Merge Function
            @SuppressWarnings("unused")
            Map<String, Integer> stringIntegerMap = IntStream.range(0, Math.min(integerList.size(), stringList.size()))
                    .boxed()
                    .collect(Collectors.toMap(
                            stringList::get,
                            integerList::get,
                            (existingValue, newValue) -> existingValue // ✅ Keeps first value, ignores duplicates
                    ));

            System.out.println("Final Map: " + stringIntegerMap);

        } catch (NullPointerException e) {
            System.err.println("Error: Null values found in the list! " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Error: Duplicate keys found in the list! " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Lists are not of equal length! " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Error: Unexpected Runtime Exception! " + e.getMessage());
        }
    }

}
