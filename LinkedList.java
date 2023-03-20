/* 
	File: LinkedList.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
	creates list of objects with nodes for references
*/


import java.util.Iterator;    // defines the Iterator interface
import java.util.ArrayList;   
import java.util.Collections; // contains a shuffle function

public class LinkedList<T> implements Iterable<T> {

    private class Node {
        private Node next;
        private T data;

        public Node(T item) {
            this.next = null;
            this.data = item;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public void add(T item) {
        Node newNode = new Node(item);
        newNode.setNext(head);
        head = newNode;
        size++;
    }
    
    public void add(int index, T item) {
        if (index == 0) {
            add(item);
        } else {
            Node newNode = new Node(item);
            Node currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
            size++;
        }
    }
    
    public void clear() {
        head = null;
        size = 0;
    }
    
    public boolean contains(Object o) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.getData().equals(o)) {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof LinkedList)) {
            return false;
        }
        LinkedList<?> otherList = (LinkedList<?>) o;
        if (this.size() != otherList.size()) {
            return false;
        }
        Node currNode = head;
        Node otherNode = (LinkedList<T>.Node) otherList.head;
        while (currNode != null) {
            if (!currNode.getData().equals(otherNode.getData())) {
                return false;
            }
            currNode = currNode.getNext();
            otherNode = otherNode.getNext();
        }
        return true;
    }
    
    public T get(int index) {
        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T item = head.getData();
        head = head.getNext();
        size--;
        return item;
    }
    
    public T remove(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index == 0) {
            return remove();
        }
        Node currNode = head;
        for (int i = 0; i < index - 1; i++) {
            currNode = currNode.getNext();
        }
        T item = currNode.getNext().getData();
        currNode.setNext(currNode.getNext().getNext());
        size--;
        return item;
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currNode = head;
        sb.append("[");
        while (currNode != null) {
            sb.append(currNode.getData().toString());
            if (currNode.getNext() != null) {
                sb.append(", ");
            }
            currNode = currNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

        // Inner class for iterator
        private class LLIterator implements Iterator<T> {
            private Node curr;
    
            public LLIterator(Node head) {
                curr = head;
            }
    
            public boolean hasNext() {
                return curr != null;
            }
    
            public T next() {
                T data = curr.getData();
                curr = curr.getNext();
                return data;
            }
    
            public void remove() {
                // Optional method - do nothing
            }
        }
    
        // Returns a new LLIterator pointing to the head of the list
        public Iterator<T> iterator() {
            return new LLIterator(this.head);
        }
    }

