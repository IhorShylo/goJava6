package module6;

import java.util.Arrays;

/**
 * Created by Igor on 23.03.2017.
 */
public final class UserUtils {

    private UserUtils() {
    }

    public static User[] uniqueUsers(User[] users) {
        if (users == null || users.length <= 0) return null;
        User[] uniqUsers = null;

        for (User user : users) {
            for (User user1 : users) {
                if (user != null && user.equals(user1) && !containsElem(uniqUsers, user1)) {
                    uniqUsers = addUserToArray(uniqUsers, user1);
                }
            }
        }
        return uniqUsers;
    }

    public static User[] usersWithConditionalBalance(User[] users, int balance) {
        if (users == null) return null;
        User[] resultArray = null;
        for (User user : users) {
            if (user != null && user.getBalance() == balance) resultArray = addUserToArray(resultArray, user);
        }
        return resultArray;
    }

    public static User[] paySalaryToUsers(User[] users) {
        if (users == null) return null;
        User[] resultArray = new User[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) continue;

            long newUserId = users[i].getId();
            String newFirstName = users[i].getFirstName();
            String newLastName = users[i].getLastName();
            int newUserSalary = users[i].getSalary();
            int newUserBalance = users[i].getBalance() + newUserSalary;

            resultArray[i] = new User(newUserId, newFirstName, newLastName, newUserSalary, newUserBalance);
        }

        return resultArray;
    }

    public static long[] getUsersId(User[] users) {
        if (users == null) return null;
        User[] deletedEmptyUsers = deleteEmptyUsers(users);

        long[] userIds = new long[deletedEmptyUsers.length];

        for (int i = 0; i < deletedEmptyUsers.length; i++) {
            userIds[i] = deletedEmptyUsers[i].getId();
        }
        return userIds;
    }

    public static User[] deleteEmptyUsers(User[] users) {
        if (users == null) return null;

        User[] deletedEmptyUsers = new User[users.length];
        int numberOfNotNullElements = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                deletedEmptyUsers[numberOfNotNullElements] = users[i];
                numberOfNotNullElements++;
            }
        }
        //Cut empty elements
        deletedEmptyUsers = Arrays.copyOf(deletedEmptyUsers, numberOfNotNullElements);
        return deletedEmptyUsers;
    }

    private static User[] addUserToArray(User[] array, User user) {
        User[] resultArray;
        int arrayLength;
        if (array == null) {
            resultArray = new User[1];
            arrayLength = 0;
        } else {
            arrayLength = array.length;
            resultArray = Arrays.copyOf(array, arrayLength + 1);
        }

        resultArray[arrayLength] = user;
        return resultArray;
    }

    private static boolean containsElem(User[] users, User user) {
        if (users == null || user == null) return false;

        for (User currentUser : users) {
            if (currentUser.equals(user)) return true;
        }
        return false;
    }
}
