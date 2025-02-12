package org.onboard.collections.hashtable;

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
