package exception;

public class StringNotFoundException extends RuntimeException{
    public StringNotFoundException(String message) {
        super(message);
    }
}
