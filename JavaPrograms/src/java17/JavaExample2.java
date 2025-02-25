package java17;

import java.util.List;

public class JavaExample2 {
    record Person(String name, int age) {}

    public static void main(String[] args) {
        var people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 15),
            new Person("Charlie", 40),
            new Person("David", 18)
        );

        var processedPeople = people.stream()
            .filter(person -> person.age() >= 18)
            .map(person -> new Person(person.name().toUpperCase(), person.age()))
            .toList();

        for (var person : processedPeople) {
            System.out.println(personInfo(person));
        }
    }

    static String personInfo(Person person) {
        return switch (person) {
            case Person(String name, int age) when age < 20 -> name + " is a teenager.";
            case Person(String name, int age) when age >= 20 && age < 40 -> name + " is an adult.";
            default -> person.name() + " is middle-aged.";
        };
    }
}
