package utilities;

import exceptions.EmptyQueueException;

/**
 * Interface for a generic Queue Abstract Data Type (ADT).
 *
 * @param <E> the type of elements held in this queue
 */
public interface QueueADT<E> {
    
    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to be added to the queue
     * @throws NullPointerException if the element is null
     */
    void enqueue(E element);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E dequeue() throws EmptyQueueException;

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E peek() throws EmptyQueueException;

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Removes all elements from the queue.
     */
    void clear();

    /**
     * Checks if this queue is equal to another object.
     *
     * @param obj the object to compare
     * @return true if this queue is equal to the specified object, false otherwise
     */
    boolean equals(Object obj);

    /**
     * Converts the queue to an array.
     *
     * @return an array containing all elements in the queue
     */
    E[] toArray();

    /**
     * Converts the queue to an array of the specified type.
     *
     * @param a the array into which the elements of the queue are to be stored
     * @return an array containing the elements of the queue
     * @throws NullPointerException if the specified array is null
     */
    E[] toArray(E[] a);

    /**
     * Returns an iterator over the elements in this queue.
     *
     * @return an iterator for the elements in this queue
     */
    Iterator<E> iterator();
}
