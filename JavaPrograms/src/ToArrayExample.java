import java.util.Arrays;
import java.util.List;

public class ToArrayExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Using toArray() method
        Integer[] array = list.stream().toArray(Integer[]::new);

        System.out.println(Arrays.toString(array));

        
    }
}
