package module4.homework1;

import module4.homework1.exception.BankBusinessException;
import module4.homework1.exception.BankTransactionException;

/**
 * Created by Igor on 27.02.2017.
 */
public interface BankSystem {

    void withdrawOfUser(User user, int amount) throws BankBusinessException;

    void fundUser(User user, int amount) throws BankBusinessException;

    void transferMoney(User fromUser, User toUser, int amount) throws BankBusinessException, BankTransactionException;

    void paySalary(User user) throws BankBusinessException;
}
