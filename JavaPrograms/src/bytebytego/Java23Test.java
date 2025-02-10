package bytebytego;

public class Java23Test {
    void main() {

        System.out.println(testThreadVirtual());
    }

    String testThreadVirtual() {
        // Create and start a virtual thread
        Thread.startVirtualThread(() -> {
            System.out.println("Hello from Virtual Thread!");
        });

        // Traditional thread example
        Thread thread = new Thread(() -> {
            System.out.println("Hello from traditional Thread!");
        });
        thread.start();

        return "testThreadVirtual - Done!";
    }
    
}
