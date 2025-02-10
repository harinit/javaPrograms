package threads;

import java.util.concurrent.Semaphore;

public class SemaphoreAlternatePrinting {
    public static void main(String[] args) {
        Semaphore numberSemaphore = new Semaphore(1); // Start with the number thread
        Semaphore letterSemaphore = new Semaphore(0); // Letter thread waits initially

        // Thread to print numbers (1, 2, 3)
        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    numberSemaphore.acquire(); // Acquire permit for numbers
                    System.out.print(i + " "); // Print number
                    letterSemaphore.release(); // Release permit for letters
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Thread to print letters (A, B, C)
        Thread letterThread = new Thread(() -> {
            char[] letters = {'A', 'B', 'C'};
            for (char letter : letters) {
                try {
                    letterSemaphore.acquire(); // Acquire permit for letters
                    System.out.print(letter + " "); // Print letter
                    numberSemaphore.release(); // Release permit for numbers
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        numberThread.start();
        letterThread.start();
    }
}

//Using Semaphore
	/* •	How It Works:
	•	Two semaphores (numberSemaphore and letterSemaphore) control access to the threads.
	•	Initially, numberSemaphore has 1 permit, allowing the number thread to start.
	•	After printing, each thread releases the permit for the other thread.
	•	Advantages:
	•	Simple and effective for alternating between two threads. */
