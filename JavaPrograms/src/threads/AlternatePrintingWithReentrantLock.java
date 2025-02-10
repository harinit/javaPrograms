package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrintingWithReentrantLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition numberTurn = lock.newCondition();
        Condition letterTurn = lock.newCondition();
        boolean[] isNumberTurn = {true}; // Shared state to track whose turn it is

        // Thread to print numbers (1, 2, 3)
        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                lock.lock();
                try {
                    while (!isNumberTurn[0]) { // Wait if it's not number's turn
                        numberTurn.await();
                    }
                    System.out.print(i + " "); // Print number
                    isNumberTurn[0] = false; // Switch to letter's turn
                    letterTurn.signal(); // Signal the letter thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        // Thread to print letters (A, B, C)
        Thread letterThread = new Thread(() -> {
            char[] letters = {'A', 'B', 'C'};
            for (char letter : letters) {
                lock.lock();
                try {
                    while (isNumberTurn[0]) { // Wait if it's not letter's turn
                        letterTurn.await();
                    }
                    System.out.print(letter + " "); // Print letter
                    isNumberTurn[0] = true; // Switch to number's turn
                    numberTurn.signal(); // Signal the number thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        // Start both threads
        numberThread.start();
        letterThread.start();
    }

    //Using ReentrantLock and Condition
	/* •	How It Works:
	•	A single ReentrantLock ensures mutual exclusion.
	•	Two Condition objects (numberTurn and letterTurn) manage the order of execution.
	•	The shared state (isNumberTurn) tracks whose turn it is.
	•	Advantages:
	•	Explicit control over thread signaling.
	•	Easy to extend for more complex scenarios. */

    
}