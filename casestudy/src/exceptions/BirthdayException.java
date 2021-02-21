package exceptions;

public class BirthdayException extends Exception {
    public BirthdayException() {
        super("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy”");
    }
}
