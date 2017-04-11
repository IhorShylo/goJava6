package module6;

import java.util.Arrays;

/**
 * Created by Igor on 23.03.2017.
 */
public class UsersMain {

    public static void main(String[] args) {
        User[] array = {new User(1, "Vasya", "Pupkin", 500, 1000),
                new User(1, "Vasya", "Pupkin", 500, 1000),
                new User(2, "Petya", "Pupkin", 500, 1000),
                new User(1, "Masha", "Pupkina", 5, 1005),
                null,
                new User(4, "Masha", "Pupkina", 500, 1000),
        };

        System.out.println("Array with uniqUsers users:");
        printUserArray(UserUtils.uniqueUsers(array));

        System.out.println("Array without empty users:");

        printUserArray(UserUtils.deleteEmptyUsers(array));

        System.out.println("Payed salary:");
        printUserArray(UserUtils.paySalaryToUsers(array));


        System.out.println("Users id's:");
        System.out.println(Arrays.toString(UserUtils.getUsersId(array)));


        int balance = 1005;
        System.out.println("Users with balance = " + balance);
        printUserArray(UserUtils.usersWithConditionalBalance(array, balance));


    }

    private static void printUserArray(User[] users) {
        if (users == null){
            System.out.println("Array is null");
            return;
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

}
