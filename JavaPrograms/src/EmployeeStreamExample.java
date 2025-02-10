import java.util.*;

public class EmployeeStreamExample {
    public static void main(String[] args) {

        // List of employees represented as Maps
        List<Map<String, Object>> employees = Arrays.asList(
            createEmployee("Alice", 15000),
            createEmployee("Bob", 8000),
            createEmployee("Charlie", 12000),
            createEmployee("David", 9500),
            createEmployee("Eve", 11000)
        );

        // Use stream to filter and print employees with salary > 10000
        employees.stream()
                 .filter(employee -> (double) employee.get("salary") > 10000)  // Filter employees with salary > 10000
                 .forEach(employee -> System.out.println("Name: " + employee.get("name") + ", Salary: " + employee.get("salary")));  // Print each filtered employee
    }

    // Helper method to create employee map
    private static Map<String, Object> createEmployee(String name, double salary) {
        Map<String, Object> employee = new HashMap<>();
        employee.put("name", name);
        employee.put("salary", salary);
        //employee.remove("Alice", "15000");
        return employee;
    }
}
// return Concurrent Exception


// import java.util.*;

// public class ConcurrentModificationExample {
//     public static void main(String[] args) {

//         // Create a List of Strings
//         List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

//         // Iterate through the list and remove an element while iterating
//         for (String item : list) {
//             System.out.println(item);
//             if (item.equals("B")) {
//                 // Attempting to remove an element from the list while iterating causes ConcurrentModificationException
//                 list.remove("B");
//             }
//         }
//     }
// }

// Output of above commented example

/* A
B
Exception in thread "main" java.util.ConcurrentModificationException
    at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
    at java.util.ArrayList$Itr.next(ArrayList.java:859)
    at ConcurrentModificationExample.main(ConcurrentModificationExample.java:14) */

    // FIx 

  /*   import java.util.*;

public class ConcurrentModificationExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
            if (item.equals("B")) {
                iterator.remove();  // Use iterator's remove() method to safely remove elements
            }
        }
    }
}

Use Iterator for Safe Removal: If you need to remove elements while iterating, you can use the Iterator explicitly,
 which has a remove() method designed for safe removal during iteration. */

/*  import java.util.*;

public class ConcurrentModificationExample {
    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C", "D"));
        
        for (String item : list) {
            System.out.println(item);
            if (item.equals("B")) {
                list.remove("B");  // This will not throw ConcurrentModificationException
            }
        }
    }
}

Use CopyOnWriteArrayList: If you are working with multi-threaded environments and need to modify the collection while iterating, 
you can use a CopyOnWriteArrayList (or other concurrent collections) which allows modifications while iterating. */

