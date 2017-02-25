package module2;

import java.util.Arrays;

/**
 * You need to write method which will fund (пополнение) balance of particular user. Print name + balance after funding
 * <p/>
 * Input
 * <p/>
 * int[] balances = {1200, 250, 2000, 500, 3200};
 * <p/>
 * String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};
 * <p/>
 * String ownerName = Oww
 * double withdrawal = 100;
 * <p/>
 * Output
 * Oww 600
 */
public class Homework02_4 {

    public static void main(String[] args) {
        int[] balances = {1200, 250, 2000, 500, 3200};
        String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

        withdrawMoney(balances, ownerNames, "Lane", 3000);


    }


    public static void withdrawMoney(int[] balances, String[] owners, String ownerName, double fund) {
        if (ownerName == null || !Arrays.asList(owners).contains(ownerName)
                || fund < 0 || balances.length != owners.length) {
            System.out.println("Wrong input");
        } else {
            int ownerIndex = 0;
            for (int i = 0; i < owners.length; i++) {
                if (owners[i].equals(ownerName)) ownerIndex = i;
            }

            int ownerBalance = balances[ownerIndex];
            double balanceAfterWithdraw = ownerBalance + fund;

            System.out.println(ownerName + " " + balanceAfterWithdraw);
        }
    }

}
