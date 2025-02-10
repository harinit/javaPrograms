package javaStrings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringReverse {
    public static void main(String[] args) {
        String str = "Java Community Edition";
        String reverseStr = new StringBuilder(str).reverse().toString();
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reverseStr);

        //Without built in functions

        char[] strArray = str.toCharArray();
        String reversed = "";
        for (int i = strArray.length - 1; i >= 0; i--) {
            reversed += strArray[i];
        }
        System.out.println("Reversed String: " + reversed);

        // Using Java 8 Steams library
        String input = "Hello This is a Java Community Edition";
        String reversedString = IntStream.range(0, input.length())
                .mapToObj(i -> input.charAt(input.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Reversed: " + reversedString);

        //Using Java 8 Functional reduce() method
        String reversedString2 = Stream.of(input.split(" ")) // Reduce the space b/w Line 24
                .reduce("", (a, b) -> b + a);

        System.out.println("Reversed: " + reversedString2);

        //Using chars() Stream (Java 8+)
        String input1 = "Hello";
        String reversed3 = input1.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);

        System.out.println("Reversed: " + reversed3);
    }
}
