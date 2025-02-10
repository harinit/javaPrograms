package regular.optional;
import java.util.Optional;

public class OptionalExampleOne {
    public static void main(String[] args) {
        String name = null;
        Optional<String> optionalName = Optional.ofNullable(name);

        String result = optionalName.orElse("Unknown");
        System.out.println("Name: " + result);
    }
}