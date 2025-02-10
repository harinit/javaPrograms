import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        // Using stream distinct()
        List<Integer> uniqueList = list.stream()
            .distinct()
            .collect(Collectors.toList());

        System.out.println(uniqueList);

        // Palindrome
        String str = "madam";

        boolean isPalindrome = new StringBuilder(str).reverse().toString().equals(str);

        System.out.println("Is the string a palindrome? " + isPalindrome);
    }
}