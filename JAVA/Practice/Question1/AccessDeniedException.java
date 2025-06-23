// AccessDeniedException.java
// Custom exception thrown when a password does not match for a valid username.
public class AccessDeniedException extends Exception {

    public AccessDeniedException(String message) {
        super(message);
    }
}
