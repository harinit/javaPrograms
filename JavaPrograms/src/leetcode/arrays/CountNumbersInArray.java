package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountNumbersInArray {
     public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,4,1,2,3};
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of 1s, 2s, and 3s
        for (int num : arr) {
            if (num >= 1 && num <= 3) { // Only count 1s, 2s, and 3s
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        // Print the count of each number
        System.out.println("Count of 1s: " + countMap.getOrDefault(1, 0));
        System.out.println("Count of 2s: " + countMap.getOrDefault(2, 0));
        System.out.println("Count of 3s: " + countMap.getOrDefault(3, 0));

        System.out.println("Using Java 8 Streams:");
        //Java 8 compatibility
        List<Integer> list = Arrays.asList(1,2,2,3,3,4,4,1,2,3);

        // Count occurrences using Streams
        Map<Integer, Long> countMapUsingJava8 = list.stream()
            .filter(num -> num >= 1 && num <= 3) // Filter only 1s, 2s, and 3s
            .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        // Print the count of 1s, 2s, and 3s
        System.out.println("Count of 1s: " + countMapUsingJava8.getOrDefault(1, 0L));
        System.out.println("Count of 2s: " + countMapUsingJava8.getOrDefault(2, 0L));
        System.out.println("Count of 3s: " + countMapUsingJava8.getOrDefault(3, 0L));

        //Functional Programming Code to Iterate Over a List and Retrieve Values
        System.out.println("Functional Programming Code to Iterate Over a List and Retrieve Values:");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Java 8 Functional Iteration
        names.forEach(System.out::println);

        // OR using lambda
        names.forEach(name -> System.out.println("Name: " + name));
    }
}
