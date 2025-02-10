import java.util.Objects;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding equals method
    @Override
    public boolean equals(Object obj) {
        // Check if the two objects are the same
        if (this == obj) {
            return true;
        }
        // Check if the object is an instance of Person
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);  // Compare name and age
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Generate a hash code based on name and age
    }

    // Getters and toString for printing
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class HashCodeEquals {
    public static void main(String[] args) {
        Person person1 = new Person("John", 25);
        Person person2 = new Person("John", 25);
        Person person3 = new Person("Jane", 30);

        // Checking if two persons are equal
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // true
        System.out.println("person1.equals(person3): " + person1.equals(person3)); // false

        // Checking hash codes
        System.out.println("person1.hashCode(): " + person1.hashCode());
        System.out.println("person2.hashCode(): " + person2.hashCode());
        System.out.println("person3.hashCode(): " + person3.hashCode());
        
        // Using hash code in a HashSet to demonstrate uniqueness
        System.out.println("person1 in set: " + (new java.util.HashSet<Person>()).add(person1));
        System.out.println("person2 in set: " + (new java.util.HashSet<Person>()).add(person2)); // Will not add if equals() is true
    }
}