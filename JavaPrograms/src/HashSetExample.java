import java.util.HashSet;

class MyHashSet<E> {
    // Inner class representing the entry in the HashMap (used as a backing store)
    private static class Entry<K> {
        final K key;
        Entry(K key) {
            this.key = key;
        }
    }

    // Array to store the entries (this mimics the buckets in a hash table)
    private Entry<?>[] table;
    private static final int DEFAULT_CAPACITY = 16;
    @SuppressWarnings("unused")
    private static final float LOAD_FACTOR = 0.75f;
    private int size = 0;

    public MyHashSet() {
        table = new Entry[DEFAULT_CAPACITY];
    }

    // Hash function to calculate index for a given element
    private int hash(Object key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Add an element to the HashSet
    public boolean add(E e) {
        int index = hash(e);
        // If there's no element at that index, we insert it
        if (table[index] == null) {
            table[index] = new Entry<>(e);
            size++;
            return true;
        }

        // If there's an element already, we check for equality
        if (table[index].key.equals(e)) {
            return false; // Duplicate element, do not add
        }

        // Otherwise, handle the collision by chaining (in case of hash collisions)
        // For simplicity, we don't handle resizing and rehashing in this basic version
        return false;
    }

    // Check if the set contains an element
    public boolean contains(Object e) {
        int index = hash(e);
        return table[index] != null && table[index].key.equals(e);
    }

    // Remove an element from the HashSet
    public boolean remove(Object e) {
        int index = hash(e);
        if (table[index] != null && table[index].key.equals(e)) {
            table[index] = null; // Remove the entry at the computed index
            size--;
            return true;
        }
        return false;
    }

    // Get the size of the HashSet
    public int size() {
        return size;
    }

    // Print the set elements for debugging
    public void printSet() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": " + table[i].key);
            }
        }
    }

    public static void main(String[] args) {
        // MyHashSet<String> set = new MyHashSet<>();

        // set.add("apple");
        // set.add("banana");
        // set.add("orange");
        // set.add("apple");

        // System.out.println("Contains apple: " + set.contains("apple")); // true
        // System.out.println("Contains pear: " + set.contains("pear")); // false

        // set.printSet();  // Print all elements

        // set.remove("banana");
        // System.out.println("After removing 'banana':");
        // set.printSet();

        
            HashSet<String> hset = new HashSet<>();
            hset.add("apple");
            hset.add("banana");
            hset.add("cherry");
    
            System.out.println("Set contains 'banana': " + hset.contains("banana")); // true
            System.out.println("Set size: " + hset.size()); // 3
            
    
            hset.remove("banana");
            System.out.println("Set contains 'banana' after removal: " + hset.contains("banana")); // false
        
    }
}