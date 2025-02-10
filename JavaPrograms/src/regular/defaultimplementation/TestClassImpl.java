package regular.defaultimplementation;

interface TestClassWithAbstractInterface {

    // abstract method
    public void square(int a);

    // default method
    default void show()
    {
      System.out.println("Default Method Executed");
    }

    static void showStatic() {
        System.out.println("Static Method Executed");
    }
    
}

class TestClassImpl implements TestClassWithAbstractInterface {
  
    // implementation of square abstract method
    public void square(int a)
    {
        System.out.println(a*a);
    }

    public static void main(String[] args)
    {
        TestClassImpl d = new TestClassImpl();
        d.square(4);

        // default method executed
        d.show();

        // static method executed
        TestClassWithAbstractInterface.showStatic();
    }
}
