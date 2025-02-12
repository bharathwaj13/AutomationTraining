package org.onboard.collections.doublylinkedlist;

import java.util.Optional;

public class DoublyLinkedListImpl implements DoublyLinkedList {
    private Node head;
    private Node tail;


    private static class Node {
        Object element;
        Node prev;
        Node next;

        Node(Object element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        }
    }

    public DoublyLinkedListImpl() {
        this.head = null;
        this.tail = null;
    }

    public boolean addFirst(Object element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        return true;
    }

    public boolean addLast(Object element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        Node newNode = new Node(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node currentNode = head;
        int currentIndex = 0;

        while (currentNode != null) {
            if (currentIndex == index) {
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }

                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                } else {
                    tail = currentNode.prev;
                }
                return true;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    public Optional<Object> remove(Object element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.element.equals(element)) {
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }

                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                } else {
                    tail = currentNode.prev;
                }

                return Optional.of(currentNode.element);
            }
            currentNode = currentNode.next;
        }

        return Optional.empty();
    }

    public boolean set(int index, Object element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node currentNode = head;
        int currentIndex = 0;

        while (currentNode != null) {
            if (currentIndex == index) {

                currentNode.element = element;
                return true;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }

        throw new IndexOutOfBoundsException("Index out of range");
    }

    public int size() {
        int size = 0;
        Node currentNode = head;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }

        return size;
    }

    public Object[] toArray() {
        int size = size();
        Object[] array = new Object[size];
        Node currentNode = head;
        int index = 0;

        while (currentNode != null) {
            array[index++] = currentNode.element;
            currentNode = currentNode.next;
        }

        return array;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.element.toString());
            if (currentNode.next != null) {
                sb.append(" ");
            }
            currentNode = currentNode.next;
        }

        return sb.toString();
    }
}

