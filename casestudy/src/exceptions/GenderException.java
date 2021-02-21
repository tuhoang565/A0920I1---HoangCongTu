package exceptions;

public class GenderException extends Exception {
    public GenderException() {
        super("Male, Female hoặc Unknow");
    }
}
