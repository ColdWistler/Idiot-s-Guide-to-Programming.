// IncompleteDataException.java
// Custom exception thrown when a line in the input file does not match the expected format.
public class IncompleteDataException extends Exception {

    public IncompleteDataException(String message) {
        super(message);
    }
}
