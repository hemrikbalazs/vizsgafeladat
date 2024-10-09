package oop.events;

import java.util.EventObject;

/**
 *
 * @author Hemrik Balázs
 */
public class ErrorEvent extends EventObject {
    
    private String message;

    public ErrorEvent(String message, Object source) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    
    
}
