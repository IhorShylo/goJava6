package module4.homework1.exception;

/**
 * Created by Igor on 27.02.2017.
 */
public class BankBusinessException extends BankException {

    public BankBusinessException(String message) {
        super(message);
    }

    public BankBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
