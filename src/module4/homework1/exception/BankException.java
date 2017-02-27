package module4.homework1.exception;

/**
 * Created by Igor on 27.02.2017.
 */
public class BankException extends Exception {
    public BankException(String message) {
        super(message);
    }

    public BankException(String message, Throwable cause) {
        super(message, cause);
    }
}
