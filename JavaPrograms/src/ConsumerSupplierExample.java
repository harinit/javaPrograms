import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerSupplierExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eva");

        // Example 1: Using a lambda expression
        Consumer<String> printName = (name) -> System.out.println(name);
        names.forEach(printName);

        System.out.println("************************* Consumer Example ***********************");

        // Example 2: Using a method reference
        Consumer<String> printUpperCase = System.out::println;
        names.forEach(printUpperCase.andThen(String::toUpperCase));

        System.out.println("************************* Supplier Example ***********************");
        // Example 1: Using a lambda expression
        Supplier<String> randomStringSupplier = () -> "Hello, World!";
        System.out.println(randomStringSupplier.get());

        // Example 2: Using a method reference
        Supplier<Double> randomNumberSupplier = Math::random;
        System.out.println(randomNumberSupplier.get());
    }
}
