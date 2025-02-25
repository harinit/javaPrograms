package regular.streams;

import java.util.*;
import java.util.stream.*;

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
}

// Create a Map from a List of Person objects with their ids as keys and names
// as values.
public class CreateMapFromList {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person(1, "Alice"), new Person(2, "Bob"), new Person(3, "Charlie"),
                new Person(3, "Dave"));

        // Map<Integer, Person> personMap =
        // list.stream().collect(Collectors.toMap(Person::getId, person -> person));

        // Handle duplicate keys by keeping the first encountered value
        @SuppressWarnings("unused")
        Map<Integer, Person> personMap = list.stream()
                .collect(Collectors.toMap(
                        Person::getId,
                        person -> person,
                        (existing, replacement) -> existing // Merge strategy: Keep first occurrence
                ));

        /*
         * Alternative: Keeping the Last Encountered Value 
         * 
         * .collect(Collectors.toMap(
         * Person::getId,
         * person -> person,
         * (existing, replacement) -> replacement // Keep the latest occurrence
         * ));
         * 
         * Alternative: Concatenating Names for Duplicates
         * 
         * .collect(Collectors.toMap(
         * Person::getId,
         * person -> person.getName(),
         * (existing, replacement) -> existing + ", " + replacement
         * ));
         * 
         * 
         * ID: 1, Name: Alice
            ID: 2, Name: Bob
            sID: 3, Name: Charlie, Dave
         */
        // Print result
        // personMap.forEach((key, value) ->
        // System.out.println("ID: " + key + ", Name: " + value.getName()));

        /*
         * Strategy                     Merge Function                                              Behavior
         * Keep First Value             (existing, replacement) -> existing                         Keeps the first occurrence and ignores the duplicate.
         * Keep Last Value              (existing, replacement) -> replacement                      Keeps the last occurrence and replaces the duplicate.
         * Concatenate Values           (existing, replacement) -> new Person(existing.getId(),
         *                               existing.getName() + ", " + replacement.getName())          Merges the names instead of replacing.
         * Throw Exception               (existing, replacement) -> { throw new
         *                                 IllegalStateException("Duplicate key: " + existing.getId()); }       Throws an error if a duplicate key is found.
         * 
         * //System.out.println(personMap);
         */
        personMap.forEach((key, value) -> System.out.println("ID: " + key + ", Name: " + value.getName()));


        // DUPLICATE KEY LIST USING GROUPINGBY

        List<Person> duplicateList = Arrays.asList(
                new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(3, "Charlie"),
                new Person(3, "Dave"),  // Duplicate key
                new Person(2, "Eve"),   // Duplicate key
                new Person(4, "Frank")
        );

        // Group by id, storing all persons with the same id in a list
        Map<Integer, List<Person>> groupedPersons = duplicateList.stream()
                .collect(Collectors.groupingBy(Person::getId));

        // Print grouped result
        groupedPersons.forEach((key, value) -> 
            System.out.println("ID: " + key + ", Persons: " + value));
            /*
             * ✅ Explanation
             * • Instead of a single Person per id, we store a List for each id.
             * • groupingBy(Person::getId) ensures that all persons with the same id are
             * grouped together.
             * • Prints a list of all persons that share the same id.
             * 
             * Alternative: Collecting Names Instead of Objects
             * 
             * If you want to store only names for each id:
             * 
             */

            Map<Integer, List<String>> groupedNames = list.stream()
                    .collect(Collectors.groupingBy(
                            Person::getId,
                            Collectors.mapping(Person::getName, Collectors.toList()) // Extract only names
                    ));

            groupedNames.forEach((key, value) -> System.out.println("ID: " + key + ", Names: " + value));

            /*
             * ID: 1, Names: [Alice]
               ID: 2, Names: [Bob, Eve]
               ID: 3, Names: [Charlie, Dave]
               ID: 4, Names: [Frank]
               
               
               Approach	                                                                    Description
            .toMap(..., (existing, replacement) -> existing)	                                Keeps first occurrence, ignores duplicates
            .toMap(..., (existing, replacement) -> replacement)	                                Keeps last occurrence, replaces duplicates
            .toMap(..., (existing, replacement) -> existing + ", " + replacement)	            Merges duplicates by concatenating names
            .groupingBy(Person::getId)	                                                        Groups duplicates into a List<Person>
            .groupingBy(Person::getId, mapping(Person::getName, toList()))	                    Groups names instead of objects
               */


    
    }   
}
