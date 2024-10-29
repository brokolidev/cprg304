// MyNode.java
package exercise2;

public class MyNode<E> {

    private E element;
    private MyNode<E> next;
    private MyNode<E> prev;

    // Constructor
    public MyNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    // Getters and setters for element, next, and prev
    public E getElement() {
        return element;
    }

    public MyNode<E> getNext() {
        return next;
    }

    public MyNode<E> getPrev() {
        return prev;
    }

    public void setNext(MyNode<E> next) {
        this.next = next;
    }

    public void setPrev(MyNode<E> prev) {
        this.prev = prev;
    }
}
