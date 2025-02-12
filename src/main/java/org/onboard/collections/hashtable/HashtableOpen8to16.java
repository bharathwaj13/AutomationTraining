package org.onboard.collections.hashtable;

public interface HashtableOpen8to16 {

    HashtableOpen8to16Impl getInstance();

    void insert(int key, Object value);

    Object search(int key);

    void remove(int key);

    int size();

    int[] keys();
}
