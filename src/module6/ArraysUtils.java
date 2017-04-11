package module6;

/**
 * Created by Igor on 23.03.2017.
 */
public final class ArraysUtils {

    private ArraysUtils() {
    }

    public static int sum(int[] array) {
        int sum = 0;

        for (int item : array) {
            sum += item;
        }
        return sum;
    }

    public static int min(int[] array) {
        int min = array.length > 0 ? array[0] : 0;

        for (int item : array) {
            if (item < min) min = item;
        }

        return min;
    }

    public static int max(int[] array) {
        int max = array.length > 0 ? array[0] : 0;

        for (int item : array) {
            if (item > max) max = item;
        }

        return max;
    }

    public static int maxPositive(int array[]) {
        int maxPositive = -1;

        for (int item : array) {
            if (item > maxPositive) maxPositive = item;
        }

        return maxPositive;
    }

    public static int multiplication(int[] array) {
        if (array.length == 0) return 0;

        int multiplication = array[0];

        for (int i = 1; i < array.length; i++) {
            multiplication *= array[i];
        }

        return multiplication;
    }

    public static int[] modulus(int[] array) {
        int[] modulusArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            modulusArray[i] = (array[i] < 0) ? -array[i] : array[i];
        }

        return modulusArray;
    }

    public static int secondLargest(int[] array) {
        if (array.length < 2){
            return 0;
        }

        int max = array[0];
        int maxIndex = 0;
        int secondLargest = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        secondLargest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxIndex == i) continue;
            if (array[i] > secondLargest) secondLargest = array[i];

        }

        return secondLargest;
    }

    public static int[] reverse(int[] array) {
        if (array == null) return null;
        int[] reverseArray = new int[array.length];
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            reverseArray[j] = array[i];
        }

        return reverseArray;
    }

    public static int[] findEvenElements(int[] array) {
        if (array == null) return null;
        int numberOfEvenElems = 0;

        for (int elem : array) {
            if (elem % 2 == 0) numberOfEvenElems++;
        }

        int[] evenArray = new int[numberOfEvenElems];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArray[j++] = array[i];
            }
        }

        return evenArray;
    }
}
