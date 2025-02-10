import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {
    // Streams example
    public static void main(String[] args) {
        // Primitive Array
        int[] premitiveArray = { 1, 2, 3, 4 };
        // Object Arrays
        Integer[] objectArray = { 1, 2, 3, 4 };

        final IntStream intStream = Arrays.stream(premitiveArray);
        intStream.forEach(System.out::println);

        System.out.println("************************************");
        final Stream<Integer> integerStream = Stream.of(objectArray);
        integerStream.forEach(System.out::println);

        System.out.println("----");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        integerList.stream()
                .forEach(System.out::println);

        // Filter
        System.out.println("Filter Example");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // Reverse the numbers using STREAMS
        List<Integer> lists = Arrays.asList(217, 317, 417, 517);
        lists.stream()
                .sorted(Collections.reverseOrder()) // Method on Stream<Integer>
                .forEach(System.out::println);

        LinkedList<Integer> reversed = new LinkedList<>();
        lists.parallelStream()
                .forEachOrdered(reversed::addFirst);

        System.out.println("Reversed List: " + reversed);

    }
}
