package regular.streams;

import java.util.*;

public class FindMinValue {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList( 10, 2, 30, 40, 50, 60, 70, 8, 90);
        Optional<Integer> minValue = values.stream().min(Comparator.naturalOrder());
        
        int min = minValue.orElse(Integer.MAX_VALUE);
        System.out.println("Minimum value: " + min);  // Output: Minimum value: 10

       // minValue.ifPresentOrElse(System.out::println, () -> System.out.println("No value found"));

    }
}
