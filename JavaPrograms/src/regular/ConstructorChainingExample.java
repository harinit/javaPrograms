package regular;

public class ConstructorChainingExample {

    String name;
    int age;
    String department;

    // Constructor 1: No-argument constructor
    ConstructorChainingExample() {
        this("Unknown", 25, "General"); // Calls Constructor 3
        System.out.println("No-arg constructor called");
    }

    // Constructor 2: Calls Constructor 3
    ConstructorChainingExample(String name, int age) {
        this(name, age, "General"); // Calls Constructor 3
        System.out.println("Two-arg constructor called");
    }

    // Constructor 3: Main constructor
    ConstructorChainingExample(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
        System.out.println("Three-arg constructor called");
    }

    void display() {
        System.out.println("Employee{name='" + name + "', age=" + age + ", department='" + department + "'}");
    }

    public static void main(String[] args) {
        System.out.println("********************************");
        ConstructorChainingExample emp1 = new ConstructorChainingExample(); // Calls Constructor 1 -> 3
        emp1.display();

        System.out.println("2> ********************************");
        ConstructorChainingExample emp2 = new ConstructorChainingExample("Alice", 30); // Calls Constructor 2 -> 3
        emp2.display();

        System.out.println("3> ********************************");
        ConstructorChainingExample emp3 = new ConstructorChainingExample("Bob", 40, "IT"); // Calls Constructor 3
                                                                                           // directly
        emp3.display();
    }

    /*
     * 
     * Constructor chaining in Java refers to the process of calling one constructor
     * from another constructor within the same class or from a subclass (using
     * super()). It allows code reuse and helps avoid redundancy.
     * 1. How to Chain Constructors in the Same Class?
     * 
     * In Java, constructor chaining in the same class is done using the this()
     * keyword.
     * 
     * 2. Why Use Constructor Chaining?
     * 
     * ✅ Avoids duplicate code – Common initialization logic is written only once.
     * ✅ Improves maintainability – Changes to logic only need to be made in one
     * place.
     * ✅ Makes object creation flexible – Different constructors allow different
     * ways to initialize an object.
     * 
     * 3. Rules of Constructor Chaining
     * 1. this() must be the first statement in a constructor.
     * 2. You cannot have a cycle (e.g., Constructor A calls Constructor B, which
     * calls Constructor A).
     * 3. A constructor can call another constructor, but it must be the first
     * statement.
     */
}
