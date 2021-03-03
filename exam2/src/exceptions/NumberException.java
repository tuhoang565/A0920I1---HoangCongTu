package exceptions;

public class NumberException extends Exception {
    public NumberException() {
        super("Input must be > 0");
    }
}
