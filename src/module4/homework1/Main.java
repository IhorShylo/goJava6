package module4.homework1;

import module4.homework1.exception.BankBusinessException;
import module4.homework1.exception.BankTransactionException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 27.02.2017.
 */
public class Main {
    public static final BankSystem bankSystem = new BankSystemImpl();

    public static void main(String[] args) throws BankBusinessException, BankTransactionException {
        Bank bankUS = new USBank(1, "USA", Currency.USD, 25, 50, 5, 500_000_000);
        Bank bankEU = new EUBank(2, "Switzerland", Currency.EUR, 50, 150, 5, 1_000_000_000);
        Bank bankChina = new ChinaBank(3, "China", Currency.USD, 10, 100, 5, 50_000_000);


        User user1 = new User(1, "FirstUser", 10_000, 6, "Vodafone", 5_000, bankUS);
        User user2 = new User(2, "SecondUser", 12_000, 12, "LifeCell", 10_000, bankEU);
        User user3 = new User(3, "ThirdUser", 15_000, 18, "KyivStar", 15_000, bankChina);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);


        for (User user : users) {
            bankSystem.fundUser(user, 600);
            bankSystem.withdrawOfUser(user, 50);
            bankSystem.paySalary(user);
        }

        bankSystem.transferMoney(user3, user1, 99);

        System.out.println("--------------------------------------");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);


    }
}
