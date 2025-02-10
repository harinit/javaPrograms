package bytebytego.RecordTypes;

//public record Person(String name, int age) {}

public record Person(String name, int age) implements Greetable {
    @Override
    public void greet() {
        System.out.println("Hello, " + name);
    }

    //To call Greetable.java
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        person.greet();  // Calls the greet method
    }
}

