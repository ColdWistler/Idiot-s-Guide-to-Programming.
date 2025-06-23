// InvalidEmailException.java
// Custom exception for when an entered email ID is not recognized.
public class InvalidEmailException extends Exception {

    public InvalidEmailException(String message) {
        super(message);
    }
}
