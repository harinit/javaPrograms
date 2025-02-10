package threads;

public class AlternatePrinting {
    private static final Object lock = new Object();
    // private static boolean isNumberTurn = true; // Flag to control the
    // alternation

    // public static void main(String[] args) {
    // // Thread to print numbers (1, 2, 3)
    // Thread numberThread = new Thread(() -> {
    // for (int i = 1; i <= 3; i++) {
    // synchronized (lock) {
    // while (!isNumberTurn) { // Wait if it's not this thread's turn
    // try {
    // lock.wait();
    // } catch (InterruptedException e) {
    // Thread.currentThread().interrupt();
    // }
    // }
    // System.out.print(i + " "); // Print the number
    // isNumberTurn = false; // Set flag for the letter thread
    // lock.notify(); // Notify the other thread
    // }
    // }
    // });

    // // Thread to print letters (A, B, C)
    // Thread letterThread = new Thread(() -> {
    // char[] letters = { 'A', 'B', 'C' };
    // for (char letter : letters) {
    // synchronized (lock) {
    // while (isNumberTurn) { // Wait if it's not this thread's turn
    // try {
    // lock.wait();
    // } catch (InterruptedException e) {
    // Thread.currentThread().interrupt();
    // }
    // }
    // System.out.print(letter + " "); // Print the letter
    // isNumberTurn = true; // Set flag for the number thread
    // lock.notify(); // Notify the other thread
    // }
    // }
    // });

    private static boolean isLetterTurn = true; // Flag to control the alternation

    public static void main(String[] args) {
        // Thread to print letters (A, B, C)
        Thread letterThread = new Thread(() -> {
            char[] letters = { 'A', 'B', 'C' };
            for (char letter : letters) {
                synchronized (lock) {
                    while (!isLetterTurn) { // Wait if it's not this thread's turn
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(letter + " ");
                    isLetterTurn = false; // Set the flag for the number thread
                    lock.notify(); // Notify the other thread
                }
            }
        });

        // Thread to print numbers (1, 2, 3)
        Thread numberThread = new Thread(() -> {
            int[] numbers = { 1, 2, 3 };
            for (int number : numbers) {
                synchronized (lock) {
                    while (isLetterTurn) { // Wait if it's not this thread's turn
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(number + " ");
                    isLetterTurn = true; // Set the flag for the letter thread
                    lock.notify(); // Notify the other thread
                }
            }
        });
        // Start both threads
        numberThread.start();
        letterThread.start();

    }

    /*
     * • Synchronization: Ensures threads do not interfere with each other and print
     * in the correct order.
     * 
     * • Wait and Notify: Provides a way to coordinate between the two threads.
     * 
     * • Thread Safety: The shared flag (isLetterTurn) and lock object ensure
     * thread-safe access and synchronization.
     */
}