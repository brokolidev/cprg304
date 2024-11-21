package exceptions;

/**
 * Exception thrown when an operation is performed on an empty stack.
 */
public class EmptyStackException extends RuntimeException {

    /**
     * Constructs an EmptyStackException with no detail message.
     */
    public EmptyStackException() {
        super("Stack is empty.");
    }

    /**
     * Constructs an EmptyStackException with a specified detail message.
     * 
     * @param message the detail message
     */
    public EmptyStackException(String message) {
        super(message);
    }
}