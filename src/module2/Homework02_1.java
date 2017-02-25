package module2;

import java.util.Arrays;

/**
 * Input: array with size = 10 can be of one of two data types: int and double. Calculate:
 * <p/>
 * sum
 * min/max
 * max positive
 * multiplication
 * modulus of first and last element
 * second largest element
 * <p/>
 * As a result you should have methods with following names :
 * <p/>
 * sum(int array[]), sum(double[])
 * min(int array[]), min(double[])
 * max(int array[]), max(double[])
 * maxPositive(int array[]), maxPositive(double array[]),
 * multiplication  (int array[]), multiplication (double[])
 * modulus(int array[]), modulus(double[])
 * secondLargest(int array[]), secondLargest(double[])
 */
public class Homework02_1 {
    public static void main(String[] args) {
        double[] array = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        double[] array1 = {-15.0, 13.2, -5, 0, -5, -847.0, -51, -26, -9, -10};
//        double[] array1 = {15.0, 13.2, -5, 0, 5, 847.0, -51, 26, 9, 10};

        System.out.println("sum = " + sum(array));
        System.out.println("min = " + min(array));
        System.out.println("max = " + max(array));
        System.out.println("maxPositive = " + maxPositive(array));
        System.out.println("multiplication = " + multiplication(array));
        System.out.println("modulus = " + Arrays.toString(modulus(array1)));
        System.out.println("secondLargest = " + secondLargest(array));
    }

    public static double sum(double[] array) {
        double sum = 0.0;

        for (double item : array) {
            sum += item;
        }
        return sum;
    }

    public static double min(double[] array) {
        double min = array.length > 0 ? array[0] : 0;

        for (double item : array) {
            if (item < min) min = item;
        }

        return min;
    }

    public static double max(double[] array) {
        double max = array.length > 0 ? array[0] : 0;

        for (double item : array) {
            if (item > max) max = item;
        }

        return max;
    }

    public static double maxPositive(double array[]) {
        double maxPositive = 0;

        for (double item : array) {
            if (item > maxPositive) maxPositive = item;
        }

        return maxPositive;
    }

    public static double multiplication(double[] array) {
        if (array.length == 0) return 0;

        double multiplication = array[0];

        for (int i = 1; i < array.length; i++) {
            multiplication *= array[i];
        }

        return multiplication;
    }

    public static double[] modulus(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] < 0) ? -array[i] : array[i];
        }

        return array;
    }

    public static double secondLargest(double[] array) {
        if (array.length < 2) return 0;

        double max = array[0];
        int maxIndex = 0;
        double secondLargest = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        secondLargest = array[0];
        for(int i = 0; i < array.length; i++) {
            if(maxIndex == i) continue;
            if (array[i] > secondLargest) secondLargest = array[i];

        }

        return secondLargest;
    }
}
