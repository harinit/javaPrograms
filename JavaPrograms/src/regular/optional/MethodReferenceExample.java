package regular.optional;
import java.util.ArrayList;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Emily");

        // Method reference to static method
        names.forEach(System.out::println);

        // Method reference to instance method of a particular object
        names.forEach(String::toUpperCase);

        // Method reference to instance method of an arbitrary object of a particular type
        names.sort(String::compareToIgnoreCase);

        System.out.println("****************************************************************");
        System.out.println("names after sorting: " + names);

        // Method reference to constructor
        names.stream()
             .map(String::new)
             .forEach(System.out::println);
    }
}