package utilities;

import exceptions.EmptyStackException;

/**
 * StackADT is an interface that defines the basic operations of a stack.
 * It provides methods to manipulate and retrieve elements in a last-in-first-out (LIFO) manner.
 * 
 * @param <E> the type of elements in this stack
 */
public interface StackADT<E> {

    /**
     * Adds an item to the top of the stack.
     * 
     * @param item the item to be added
     * @throws NullPointerException if the item is null
     */
    void push(E item);

    /**
     * Removes and returns the item at the top of the stack.
     * 
     * @return the item removed from the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    E pop() throws EmptyStackException;

    /**
     * Returns the item at the top of the stack without removing it.
     * 
     * @return the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    E peek() throws EmptyStackException;

    /**
     * Tests whether the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the stack.
     * 
     * @return the size of the stack
     */
    int size();

    /**
     * Removes all items from the stack.
     */
    void clear();

    /**
     * Checks if the stack contains a specific item.
     * 
     * @param item the item to check for
     * @return true if the item is found, false otherwise
     * @throws NullPointerException if the item is null
     */
    boolean contains(E item);

    /**
     * Compares this stack to another stack for equality.
     * 
     * @param otherStack the stack to compare to
     * @return true if the stacks are equal, false otherwise
     */
    boolean equals(StackADT<E> otherStack);

    /**
     * Searches for the specified item in the stack and returns its position.
     * 
     * @param item the item to search for
     * @return the position of the item from the top of the stack, or -1 if not found
     */
    int search(E item);

    /**
     * Converts the stack to an array.
     * 
     * @return an array containing all of the elements in the stack
     */
    Object[] toArray();

    /**
     * Converts the stack to an array of the specified type.
     * 
     * @param array the array to fill with the stack elements
     * @return an array containing all of the elements in the stack
     * @throws NullPointerException if the specified array is null
     */
    E[] toArray(E[] array);
}