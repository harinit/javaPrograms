package regular.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // of() method
        Optional<String> optional = Optional.of("Hello, World!");
        System.out.println(optional.isPresent()); // Output: true

        // empty() method
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent()); // Output: false

        // ofNullable() method
        Optional<String> nullOptional = Optional.ofNullable(null);
        System.out.println(nullOptional.isPresent()); // Output: false

        Optional<String> name = Optional.ofNullable("John Doe");
        System.out.println(name.isPresent()); // Output: true
        name.ifPresent(System.out::println); // Output: John Doe

        // orElse() method
        String nameValue = name.orElse("Anonymous");
        System.out.println(nameValue); // Output: John Doe
        name.orElse("Anonymous"); // Output: John Doe
        String value = name.get();
        System.out.println(value); // Output: John Doe

        //isPresent() method
        Optional<String> optionalName = Optional.of("Hello, Harini!");
        System.out.println(optionalName.isPresent()); // Output: Hello, Harini!

        //map() method
        Optional<String> upperCaseName = optionalName.map(String::toUpperCase);
        upperCaseName.ifPresent(System.out::println); // Output: HELLO, HARINI!

        //orElseGet() method
        String nameValue1 = emptyOptional.orElseGet(() -> "Anonymous");
        System.out.println(nameValue1); // Output: John Doe

        //filter() method
        Optional<String> filteredName = optionalName.filter(name1 -> name1.contains("Harini "));
        filteredName.ifPresent(System.out::println); // Output: Hello, Harini!

        //flatMap() method
        Optional<String> flatMapName = optionalName.flatMap(name1 -> Optional.of(name1.toUpperCase()));
        flatMapName.ifPresent(System.out::println); // Output: HELLO, HARINI!

        //ifPresentOrElse() method
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Value not found")); // Output: Hello, Harini!  ===> Value not found
        //orElseGet() method
        emptyOptional.orElseGet(() -> "Anonymous");

        //orElseThrow() method
        //try {
            emptyOptional.orElseThrow(() -> new IllegalArgumentException("Value not found"));
        // } catch (IllegalArgumentException e) {
        //     System.out.println(e.getMessage()); // Output: Value not found
        // }
    }
}
