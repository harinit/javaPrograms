package regular.streams;

import java.util.*;
import java.util.stream.*;

public class PartitionList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);

        Map<Boolean, List<Integer>> partitionedMap = list.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Even Numbers" +partitionedMap.get(true));

        System.out.println("Odd Numbers" +partitionedMap.get(false));
    }    
}
