import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential Stream
        System.out.println("Sequential Stream:");
        numbers.stream()
                .forEach(System.out::println);

        // Parallel Stream
        System.out.println("Parallel Stream:");
        numbers.parallelStream()
                .forEach(System.out::println);
    }
}