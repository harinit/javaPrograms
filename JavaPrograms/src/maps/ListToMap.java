package maps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListToMap {
    // ## **✅ Example: Using `boxed()` to Convert `IntStream` to `Stream<Integer>`**
    // ```java
    // ### **🚀 Understanding `boxed()` in Java Streams**
    // 📌 **What is `boxed()` in Java Streams?**
    // - In Java Streams, **`IntStream`, `LongStream`, and `DoubleStream` are
    // primitive streams**.
    // - The method **`boxed()` converts primitive types (`int`, `long`, `double`)
    // to their wrapper classes (`Integer`, `Long`, `Double`).
    // - This is needed when working with **Collectors, Maps, or Lists that require
    // Objects**.

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(101, 102, 103);
        List<String> stringList = Arrays.asList("Apple", "Banana", "Cherry");

        // Convert Two Lists to a Map<String, Integer>
        Map<String, Integer> stringIntegerMap = IntStream.range(0, integerList.size()) // Creates IntStream (primitive)
                .boxed() // Converts IntStream (int) to Stream<Integer> (Object)
                .collect(Collectors.toMap(stringList::get, integerList::get));

        System.out.println("Final Map: " + stringIntegerMap);

        // Using for loop
        Map<String, Integer> stringIntegerMap1 = new HashMap<>();
        for (int i = 0; i < integerList.size(); i++) {
            stringIntegerMap1.put(stringList.get(i), integerList.get(i));
        }
    }
}
