package regular.defaultimplementation;

// Interface A
interface InterfaceA {
    default void commonMethod() {
        System.out.println("Default method from Interface A");
    }
}

// Interface B
interface InterfaceB {
    default void commonMethod() {
        System.out.println("Default method from Interface B");
    }
}

// MyClass implementing both interfaces
class MyClass implements InterfaceA, InterfaceB {
    // Overriding the common method to call both interfaces
    @Override
    /*
     * If you remove or comment out the @Override annotation but still keep the
     * commonMethod() implementation in MyClass, the code will compile and run
     * successfully because the @Override annotation is optional in Java.
     * 
     * @Override is recommended because:
	•	It helps catch mistakes (e.g., incorrect method signatures).
	•	It makes code more readable by explicitly indicating an override.
     */
    public void commonMethod() {
        InterfaceA.super.commonMethod(); // Call InterfaceA's method
        InterfaceB.super.commonMethod(); // Call InterfaceB's method
    }
}

// Test Class
public class DiamondProblemTestClass {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.commonMethod(); // Invokes the overridden method in MyClass
    }
}

// If we do not override the commonMethod() in MyClass, the Java compiler will
// throw a compilation error due to the ambiguity of multiple default methods
// with the same signature from InterfaceA and InterfaceB.

/* What If InterfaceA Had Only an Abstract Method (No Default)?

If InterfaceA defines commonMethod() as abstract (without default), then MyClass must implement it because:
	•	InterfaceA would be acting like a traditional abstract class with unimplemented methods.
	•	InterfaceB still has a default implementation, but MyClass must provide its own commonMethod() implementation to satisfy InterfaceA. 
    interface InterfaceA {  // No default method
    void commonMethod();  // Abstract method (must be implemented)

    Scenario	                                                                    What Happens?
InterfaceA is declared abstract interface (with default method)	                     Nothing changes, Java treats it like a regular interface.
InterfaceA has an abstract method (no default keyword)	                              MyClass must implement the method.
InterfaceA and InterfaceB both have default methods with the same signature	            MyClass must override the method to resolve the conflict
}*/
