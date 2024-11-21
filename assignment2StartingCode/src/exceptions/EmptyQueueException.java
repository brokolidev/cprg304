package exceptions;

/**
 * Exception thrown when attempting to access elements of an empty queue.
 */
public class EmptyQueueException extends Exception {
    /**
     * Constructs an EmptyQueueException with a specified detail message.
     *
     * @param message the detail message
     */
    public EmptyQueueException(String message) {
        super(message);
    }
}