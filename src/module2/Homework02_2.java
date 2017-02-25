package module2;

/**
 * 2.1 Write method which withdraws money from account and takes commision 5% of the transaction.
 * Print OK + commision + balance after withdrawal. Print NO is withdrawal is not possible.
 * <p/>
 * Example
 * <p/>
 * Input
 * <p/>
 * balance = 100
 * withdrawal = 10
 * <p/>
 * Output
 * OK 0.5 89.5
 * <p/>
 * Input
 * <p/>
 * balance = 100
 * withdrawal = 99
 * <p/>
 * Output
 * NO
 */
public class Homework02_2 {

    public static void main(String[] args) {
        withdrawMoney(3000, -2800);
    }

    public static void withdrawMoney(int balance, double withdrawal) {
        if (balance < 0 || withdrawal < 0) {
            System.out.println("Wrong input");
        } else {
            double commision = withdrawal * 0.05;

            double balanceAfterWithdraw = balance - withdrawal - commision;

            if(balanceAfterWithdraw > 0) {
                System.out.println("OK " + commision + " " + balanceAfterWithdraw);
            } else {
                System.out.println("NO");
            }
        }

    }

}
