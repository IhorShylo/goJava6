package module4.homework1.exception;

/**
 * Created by Igor on 27.02.2017.
 */
public class BankTransactionException extends BankException {

    public BankTransactionException(String message) {
        super(message);
    }

    public BankTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}
