package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestSalary {
    public static void main(String[] args) {
        List<Integer> salaryList = Arrays.asList(100, 200, 300, 4000, 500);
       Integer secondHighestInteger = salaryList.stream()
                //.sorted((s1, s2) -> s2 - s1)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Highest Salary: " + secondHighestInteger);

    }

    
}
