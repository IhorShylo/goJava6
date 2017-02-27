package module4.homework1;

import module4.homework1.exception.BankBusinessException;
import module4.homework1.exception.BankTransactionException;

/**
 * Created by Igor on 27.02.2017.
 */
public class BankSystemImpl implements BankSystem {

    @Override
    public void withdrawOfUser(User user, int amount) throws BankBusinessException {
        if (amount < 0) throw new BankBusinessException("Negative amount");

        double balance = user.getBalance();
        Bank bank = user.getBank();

        int limit = bank.getLimitOfWithdrawal();
        int commission = bank.getCommission(amount);

        double newBalance = balance - amount - commission;
        if (limit >= amount && newBalance >= 0) {
            user.setBalance(newBalance);
        } else if (limit < amount) {
            throw new BankBusinessException("Can't finish operation. Desire withdraw = " + amount + ", limit = " + limit);
        } else if (newBalance < 0) {
            throw new BankBusinessException("Not enough money on your count. Current balance = " + balance + ", Desire withdraw = " + amount);
        }
    }

    @Override
    public void fundUser(User user, int amount) throws BankBusinessException {
        if (amount < 0) throw new BankBusinessException("Negative amount");

        double balance = user.getBalance();
        Bank bank = user.getBank();

        int limit = bank.getLimitOfFunding();
        int commission = bank.getCommission(amount);

        double newBalance = balance + amount - commission;

        if (limit >= amount || limit == -1) {
            user.setBalance(newBalance);
        } else {
            throw new BankBusinessException("Can't finish operation. Desire withdraw = " + amount + ", limit = " + limit);
        }
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) throws BankBusinessException, BankTransactionException {
        if (amount < 0) throw new BankBusinessException("Negative amount");
        double fromUserOldBalance = fromUser.getBalance();
        double toUserOldBalance = toUser.getBalance();
        try {
            withdrawOfUser(fromUser, amount);
            fundUser(toUser, amount);
        } catch (BankBusinessException e) {
            fromUser.setBalance(fromUserOldBalance);
            toUser.setBalance(toUserOldBalance);
            throw e;
        }

    }

    @Override
    public void paySalary(User user) throws BankBusinessException {
        Bank bank = user.getBank();
        double salary = bank.moneyPaidMonthlyForSalary();
        long totalCapital = bank.getTotalCapital();

        if (totalCapital < salary) throw new BankBusinessException("Not enough money on bank balance");

        fundUser(user, (int) salary);

    }
}
