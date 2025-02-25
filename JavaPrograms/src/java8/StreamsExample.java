package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    // Given a list of integers, ﬁnd out all the numbers starting with 1 using
    // Stream functions.
    public static List<Integer> getNumbersStartsWithOne(List<Integer> numbers) {
        return numbers.stream().filter(x -> x.toString().startsWith("1"))

                .collect(Collectors.toList());

    }

    // ﬁnd duplicate elements in the list.
    public static List<Integer> ﬁndDuplicateElements(List<Integer> list) {
        Set<Integer> tempSet = new HashSet<>();
        return list.stream().filter(x -> !tempSet.add(x)).collect(Collectors.toList());
    }

    // ﬁnd largest element of the list using streams.
    public static Integer findLargestElement(List<Integer> list) {
        Integer largest = list.stream().reduce(Integer.MIN_VALUE, Integer::max);
        return largest;
        // return list.stream().max(Integer::compareTo).orElse(null);
    }

    // ���nd smallest element of the list using streams.
    public static Integer findSmallestElement(List<Integer> list) {
        Integer smallest = list.stream().reduce(Integer.MAX_VALUE, Integer::min);
        return smallest;

    }

    // ﬁnd largest element of the list using streams by comparing to Integer
    // argument.
    public static Integer findLargestElementByComparing(List<Integer> list, int target) {
        return list.stream().filter(x -> x > target).max(Integer::compareTo).orElse(null);
        // return list.stream().max(Integer::compareTo).orElse(null);
    }

    public static char ﬁndFirstNonRepeatativeCharacter(String s1) {
        return s1.chars().mapToObj(x -> (char) x).filter(x -> s1.indexOf(x) == s1.lastIndexOf(x)).findFirst()
                .orElse('0');
    }

    public static void main(String[] args) {

        // Given a list of integers, ﬁnd out all the numbers starting with 1 using
        // Stream functions.
        List<Integer> numbers = getNumbersStartsWithOne(Stream.of(7, 2, 9, 1, 5, 11).collect(Collectors.toList()));
        System.out.println(numbers);
        // Output: [1, 11]

        int[] arr = { 7, 2, 9, 1, 5, 11, 123 };
        int[] res = Arrays.stream(arr)
                .filter(s -> String.valueOf(s).startsWith("1"))
                .toArray();
        System.out.println(Arrays.toString(res));
        // Output: [1, 11, 123]

        // ﬁnd duplicate elements in the list.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3);
        List<Integer> duplicateElements = ﬁndDuplicateElements(list);

        System.out.println("Duplicate Elements :: " + duplicateElements);
        // Output: [1, 2, 3]

        // Using parallel streams
        // List<Integer> duplicateElementsParallel = list.parallelStream()
        // .filter(x -> !new HashSet<Integer>().add(x))
        // .collect(Collectors.toList());
        // System.out.println(duplicateElementsParallel);
        // Output: [1, 2, 3]

        // ﬁnd largest element of the list using streams.
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer largestElement = findLargestElement(list1);
        System.out.println("Largest Element :: " + largestElement);

        // ﬁnd largest element of the list using streams by comparing to Integer
        // argument.
        Integer largestElementByComparing = findLargestElementByComparing(list1, 5);
        System.out.println("Largest Element (by comparing 5) :: " + largestElementByComparing);
        // Output: 9, 5

        // Other stream operations
        // Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5).stream();
        // stream.forEach(System.out::println); // Output: 1, 2, 3, 4, 5
        // stream.filter(x -> x % 2 == 0).forEach(System.out::println); // Output: 2, 4
        // stream.map(x -> x * 2).forEach(System.out::println); // Output: 2, 4, 6, 8,
        // 10

        // ﬁnd smallest element of the list using streams.
        List<Integer> list2 = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer smallestElement = findSmallestElement(list2);
        System.out.println("Smallest Element :: " + smallestElement);
        // Output: 1

        // In a Given String, ﬁnd the ﬁrst non-repeated character using streams API.
        String str = "hello";
        char ch = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst()
                .orElse('\0');

        System.out.println("First non-repeated character :: " + ch);


        // In a given String, ���nd the ���rst non-repeated character using streams API
        String s1 = "harini";
        char ch1 = ﬁndFirstNonRepeatativeCharacter(s1);
        System.out.println("First non-repeated character :: " + ch1);

        

    }
}
