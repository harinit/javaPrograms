package bytebytego.RecordTypes;

public class RecordExample {
    public static void main(String[] args) {
        // Create a record instance
        Person person = new Person("Alice", 30);

        // Access fields using generated methods
        System.out.println(person.name());  // "Alice"
        System.out.println(person.age());   // 30

        // Display the record using the automatically generated toString method
        System.out.println(person);  // Person[name=Alice, age=30]

        // Comparing two records for equality
        Person person2 = new Person("Alice", 30);
        System.out.println(person.equals(person2));  // true

        Person person3 = new Person("Bob", 3);
        System.out.println(person.equals(person3));  // false

        System.out.println(person3.name());  // "Bob"
        System.out.println(person3.age()); // 3

        // Hash code generation
        System.out.println(person.hashCode());  // Hash code value
    }
}