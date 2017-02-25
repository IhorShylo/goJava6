package module2;

import java.util.Arrays;

/**
 * You need to write method which withdraw money of particular account owner if he/she can.
 * Print name + NO of withdrawal is not possible and name + sum of withdrawal + balance after withdrawal in other case. 4
 * Commision is 5% for all cases.
 * <p/>
 * Example
 * <p/>
 * Input
 * <p/>
 * int[] balances = {1200, 250, 2000, 500, 3200};
 * String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};
 * <p/>
 * String ownerName = Ann
 * double withdrawal = 100;
 * <p/>
 * Output
 * Ann 100 145
 * <p/>
 * Input
 * <p/>
 * int[] balances = {1200, 250, 2000, 500, 3200};
 * String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};
 * <p/>
 * String ownerName = Oww
 * double withdrawal = 490;
 * <p/>
 * Output
 * Oww NO
 */
public class Homework02_2 {

    public static void main(String[] args) {
        int[] balances = {1200, 250, 2000, 500, 3200};
        String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

        withdrawMoney(balances, ownerNames, "Lane", 3000);


    }


    public static void withdrawMoney(int[] balances, String[] owners, String ownerName, double withdrawal) {
        if (ownerName == null || !Arrays.asList(owners).contains(ownerName)
                || withdrawal < 0 || balances.length != owners.length) {
            System.out.println("Wrong input");
        } else {
            int ownerIndex = 0;
            for (int i = 0; i < owners.length; i++) {
                if (owners[i].equals(ownerName)) ownerIndex = i;
            }

            int ownerBalance = balances[ownerIndex];
            double commision = withdrawal * 0.05;
            double balanceAfterWithdraw = ownerBalance - withdrawal - commision;


            if (balanceAfterWithdraw < 0) {
                System.out.println(ownerName + " NO");
            } else {
                System.out.println(ownerName + " " + withdrawal + " " + balanceAfterWithdraw);
            }

        }

    }

}
