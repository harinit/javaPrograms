package java17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaExample {
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 15),
            new Person("Charlie", 40),
            new Person("David", 18)
        );

        List<Person> processedPeople = new ArrayList<>();

        for (Person person : people) {
            if (person.age >= 18) {
                processedPeople.add(new Person(person.name.toUpperCase(), person.age));
            }
        }

        for (Person person : processedPeople) {
            System.out.println(personInfo(person));
        }
    }

    static String personInfo(Person person) {
        if (person.age < 20) {
            return person.name + " is a teenager.";
        } else if (person.age >= 20 && person.age < 40) {
            return person.name + " is an adult.";
        }
        return person.name + " is middle-aged.";
    }
}