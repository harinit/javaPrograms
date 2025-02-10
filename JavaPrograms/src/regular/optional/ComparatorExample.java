package regular.optional;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        // Comparator.comparingInt() method
        String[] names = {"John", "Jane", "Alice", "Bob"};
        Arrays.sort(names, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(names)); // Output: [Alice, Bob, John, Jane]

        // Comparator.comparing() method
        String[][] namesAndAges = {{"John", "25"}, {"Jane", "30"}, {"Alice", "35"}, {"Bob", "20"}};
        // •	Arrays.sort(...): Sorts the 2D array.
        // •	Comparator.comparing(...): Specifies the sorting key.
        // •	arr -> Integer.parseInt(arr[1]):
        // •	Extracts arr[1] (age) as a String.
        // •	Converts it into an Integer using Integer.parseInt().
        // •	The sorting is performed in ascending order based on this integer value.
        // The default behavior of Arrays.sort() is ascending order.
        Arrays.sort(namesAndAges, Comparator.comparing(arr -> Integer.parseInt(arr[1])));
        System.out.println(Arrays.deepToString(namesAndAges)); // Output: [[[Bob, 20], [John, 25], [Jane, 30], [Alice, 35]]] Because ages are sorted in ascending order.

        Arrays.sort(namesAndAges, Comparator.comparing(arr -> -Integer.parseInt(arr[1])));
        Arrays.sort(namesAndAges, Comparator.comparing((String[] arr) -> Integer.parseInt(arr[1])).reversed());
        System.out.println(Arrays.deepToString(namesAndAges)); // Output: [[[Alice, 35], [John, 25], [Jane, 30], [Bob, 20]]] Because ages are sorted in descending order.

        //Comparator.naturalOrder() method
        String[] names1 = {"John", "Jane", "Alice", "Bob"};
        Arrays.sort(names1, Comparator.naturalOrder());
        System.out.println(Arrays.toString(names1)); // Output: [Alice, Bob, Jane, John]

        // Comparator.reverseOrder() method
        String[] names2 = {"John", "Jane", "Alice", "Bob"};
        Arrays.sort(names2, Comparator.reverseOrder());
        System.out.println(Arrays.toString(names2)); // Output: [John, Jane, Bob, Alice]

        // Comparator.nullsFirst() method
        String[] names3 = {"John", "Jane", "Alice", "Bob", null};
        Arrays.sort(names3, Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(Arrays.toString(names3)); // Output: [null, Alice, Bob, Jane, John]

        // Comparator.nullsLast() method
        String[] names4 = {"John", "Jane", "Alice", "Bob", null};
        Arrays.sort(names4, Comparator.nullsLast(Comparator.naturalOrder()));
    }
}
