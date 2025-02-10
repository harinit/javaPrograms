package regular.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurence {
    public static void main(String[] args) {
        List<Integer> count = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 8, 9, 10);

        Map<Integer, Long> countOccurence = count.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(countOccurence);

        countOccurence.forEach((key, value) -> System.out.println(key + " occurs " + value + " times."));
    }

   /*  1. numbers.stream(): Converts the List of integers into a stream.

    2. Collectors.groupingBy(Function.identity(),Collectors.counting()):

           groupingBy(): Groups the elements based on a key (in this case, the element itself).

        ○ Function.identity(): A function that returns the element itself, which is the key for grouping.

        ○ Collectors.counting(): A downstream collector that counts the number of elements in each group.

    3. occurrences.forEach((key, value) -> ...): Iterates over the resulting Map and prints each element and its corresponding count. */
}
