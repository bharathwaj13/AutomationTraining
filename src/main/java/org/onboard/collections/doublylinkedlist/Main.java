package org.onboard.collections.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        System.out.println("List: " + list); // "C A B"

        list.remove("A");
        System.out.println("List after removing A: " + list); // "C B"

        list.set(1, "D");
        System.out.println("List after setting index 1 to D: " + list); // "C D"

        System.out.println("Size of the list: " + list.size()); // 2

        Object[] array = list.toArray();
        System.out.println("Array: " + java.util.Arrays.toString(array)); // "[C, D]"
    }
}
