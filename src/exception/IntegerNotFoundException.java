package exception;

public class IntegerNotFoundException extends RuntimeException{
    public IntegerNotFoundException(String message) {
        super(message);
    }
}
