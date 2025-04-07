package org.onboard.collections.hashtable;

/**
 * In this task, you need to describe a hash table based on open addressing. Linear probing is used to resolve collisions.
 * Please proceed to the HashtableOpen8to16 interface and implement the getInstance() method. The method should return an instance of the class (HashtableOpen8to16Impl), which implements this interface.
 * Please proceed to the HashtableOpen8to16Impl class, which implements the HashtableOpen8to16 interface, and provide implementations of the following methods:
 * void insert(int key, Object value)
 * Inserts a key/value pair in the hash table if the key is missing or replaces the object if the key exists
 * Object search(int key)
 * Returns the object associated with the specified key. If there is no such key, it returns null.
 * void remove(int key)
 * Removes a key/value pair from the hash table if the specified key is in the hash table
 * int size()
 * Returns the number of pairs in the hash table
 * int[] keys()
 * Returns as an array all the keys distributed in the hash table
 *
 * Details:
 * The initial capacity of the hash table is 8 buckets.
 * The maximum capacity is 16; inserting more elements should raise an IllegalStateException.
 * The capacity should double each time a new element arrives and all the buckets are already occupied. For example, if 8 buckets are already filled and a new key is about to be added, the capacity should increase.
 * The capacity should be cut in half each time an element is removed if the size is not equal to 0 and the ratio of size to capacity reaches 1:4 after removing the element. For example, if there are 8 buckets and 3 elements, after removing one of them, the capacity should decrease to 4. Another example: If there are 4 buckets and 2 elements, removing one of them causes the capacity to reduce to 2.
 * Note that in the case of 2 buckets and 1 element, removing that element leads to a size of 0. In this case, there is no reduction in capacity, so the minimum capacity of the implementation is effectively 2.
 *
 * Restrictions
 * You may not:
 * Use any type from the java.util package or its subpackages, except for the java.util.Iterator
 * Use lambdas or streams when implementing this task
 *
 */

public class HashtableOpen8to16Impl implements HashtableOpen8to16 {
    private static final int INITIAL_CAPACITY = 8;
    private static final int MAX_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private int size;
    private int capacity;
    private Entry[] table;

    public HashtableOpen8to16Impl() {
        this.capacity = INITIAL_CAPACITY;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    @Override
    public HashtableOpen8to16Impl getInstance() {
        return new HashtableOpen8to16Impl();
    }

    @Override
    public void insert(int key, Object value) {
        if (size >= capacity * LOAD_FACTOR) {
            resize(capacity * 2);
        }

        int index = getIndex(key);
        int startIndex = index;

        // Linear probing for collision resolution
        while (table[index] != null && table[index].key != key) {
            index = (index + 1) % capacity;
            if (index == startIndex) {
                throw new IllegalStateException("Table is full");
            }
        }

        if (table[index] == null) {
            size++;
        }

        table[index] = new Entry(key, value);
    }

    @Override
    public Object search(int key) {
        int index = getIndex(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].key == key) {
                return table[index].value;
            }
            index = (index + 1) % capacity;
            if (index == startIndex) {
                break;
            }
        }

        return null;
    }

    @Override
    public void remove(int key) {
        int index = getIndex(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].key == key) {
                table[index] = null;
                size--;
                // Rehash subsequent elements to avoid gaps in probing
                rehashFrom(index);
                if (size <= capacity / 4 && capacity > INITIAL_CAPACITY) {
                    resize(capacity / 2);
                }
                return;
            }
            index = (index + 1) % capacity;
            if (index == startIndex) {
                break;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] keys() {
        int[] keysArray = new int[size];
        int currentIndex = 0;

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                keysArray[currentIndex++] = table[i].key;
            }
        }

        return keysArray;
    }

    private int getIndex(int key) {
        return Math.abs(key % capacity);
    }

    private void resize(int newCapacity) {
        if (newCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Table exceeded maximum capacity");
        }

        Entry[] oldTable = table;
        table = new Entry[newCapacity];
        capacity = newCapacity;
        size = 0;

        // Rehash all the elements into the new table
        for (Entry entry : oldTable) {
            if (entry != null) {
                insert(entry.key, entry.value);
            }
        }
    }

    private void rehashFrom(int index) {
        int nextIndex = (index + 1) % capacity;
        while (table[nextIndex] != null) {
            Entry entryToRehash = table[nextIndex];
            table[nextIndex] = null;
            size--;
            insert(entryToRehash.key, entryToRehash.value);
            nextIndex = (nextIndex + 1) % capacity;
        }
    }

    private static class Entry {
        int key;
        Object value;

        Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
