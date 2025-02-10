package regular.interfacesexample;

public class FuntionalInterfaceUsage {

    // Usage of the functional interface

    public class MyFunctionalInterfaceExample {
        public static void main(String[] args) {
            MyFuntionalInterface myFuntionalInterface = () -> System.out.println("Hello, World!");
            myFuntionalInterface.myMethod();

            MyFuntionalInterface.myDefaultFuntionalInterfaceMethod();
            System.out.println(myFuntionalInterface.myDefaultFuntionalInterfaceMethodWithName("John Doe"));

            MyFuntionalInterface.myStaticFuntionalInterfaceMethod();
            System.out.println(MyFuntionalInterface.myStaticFuntionalInterfaceMethodWithNameAge("John Doe", 25));

            // MyFuntionalInterface.myStaticFuntionalInterfaceMethod();

            // MyFuntionalInterface.myDefaultFuntionalInterfaceMethod();

            
        }

    }

}
