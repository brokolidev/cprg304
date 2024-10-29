// MyDList.java
package exercise2;

public class MyDList<E> {

    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    // Constructor
    public MyDList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Returns the head node (used to iterate over the list in the main function)
    public MyNode<E> getHead() {
        return head;
    }

    // Adds an item to the beginning of the list
    public void addFirst(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    // Adds an item to the end of the list
    public void addLast(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    // Removes and returns the first element from the list
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E element = head.getElement();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null; // List is now empty
        }
        size--;
        return element;
    }

    // Removes and returns the last element from the list
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E element = tail.getElement();
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null; // List is now empty
        }
        size--;
        return element;
    }

    // Returns the current size of the list
    public int size() {
        return size;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
