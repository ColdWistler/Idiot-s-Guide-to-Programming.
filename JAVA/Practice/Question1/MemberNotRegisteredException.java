// MemberNotRegisteredException.java
// Custom exception thrown when a username is not found in the system.
public class MemberNotRegisteredException extends Exception {

    public MemberNotRegisteredException(String message) {
        super(message);
    }
}
