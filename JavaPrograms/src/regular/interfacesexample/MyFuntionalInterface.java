package regular.interfacesexample;

// An interface with a single abstract method

@FunctionalInterface
public interface MyFuntionalInterface {
    void myMethod();

    // Default implementation
    /*
     * class MyFuntionalInterfaceImpl implements MyFuntionalInterface {
     * 
     * @Override
     * public void myMethod() {
     * System.out.println("Hello, World!");
     * }
     * }
     */

    static void myDefaultFuntionalInterfaceMethod() {
        System.out.println("Hello, World! from default method");
    }

    // Static method
    static void myStaticFuntionalInterfaceMethod() {
        System.out.println("Hello, World! from static method");
    }

    default String myDefaultFuntionalInterfaceMethodWithName(String name) {
        return "Hello, " + name + " from default method";
    }

    static String myStaticFuntionalInterfaceMethodWithNameAge(String name, int age) {
        return "Hello, " + name + ", you are " + age + " years old from static method";
    }

}

