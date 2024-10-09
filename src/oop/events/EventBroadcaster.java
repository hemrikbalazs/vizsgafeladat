package oop.events;

/**
 *
 * @author Hemrik Balázs
 */
public interface EventBroadcaster {
    
    void addListener(EventListener listener);
    
    void removeListener(EventListener listener);
    
    void fireEvent(String message);
}
