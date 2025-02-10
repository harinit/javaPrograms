package regular.streams;

import java.util.Arrays;
import java.util.List;

public class FilterEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

      int sumOfOddNumbs =  numbers.stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();                //.forEach(System.out::println);
                // Output: 1, 3, 5, 7, 9
                System.out.println("Sum of odd numbers: " + sumOfOddNumbs); // Output: 25
    }
}
