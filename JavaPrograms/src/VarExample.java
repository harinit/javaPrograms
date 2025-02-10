import java.util.List;

public class VarExample {
    public static void main(String[] args) {
        var number = 42; // Local variable with inferred type
        var nameVar = "Java 11"; // Local variable with inferred type
        var price = 9.99;

        System.out.println("Number: " + number);
        System.out.println("Name: " + nameVar);
        System.out.println("Price: " + price);

        var names = List.of("Alice", "Bob", "Charlie");

        for (var name : names) {
            System.out.println(name);
        }

        for (var i = 0; i < 5; i++) {
            System.out.println("Count: " + i);
        }

        List<String> list = List.of("a", "b", "c");
        list.forEach((s) -> System.out.println(s.toUpperCase()));
        list.forEach((@Deprecated var s) -> System.out.println(s.toUpperCase()));
    }
}
