package arrays;

import java.util.Arrays;

public class DuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int[] unique = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(unique));
        // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // This solution uses Java 8 Stream API to remove duplicates from the array.
    }

}
