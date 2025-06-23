// WrongCredentialsException.java
// Custom exception for when the password provided for a valid email is incorrect.
public class WrongCredentialsException extends Exception {

    public WrongCredentialsException(String message) {
        super(message);
    }
}
