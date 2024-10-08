package oop.exceptions;

/**
 * @author Hemrik Balázs
 */
public class EntityException extends RuntimeException {

    public EntityException() {
    }

    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityException(Throwable cause) {
        super(cause);
    }

}
