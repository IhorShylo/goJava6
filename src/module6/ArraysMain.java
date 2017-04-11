package module6;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Igor on 23.03.2017.
 */
public class ArraysMain {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        //Random numbers with negative
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201 + 1 + 201) - 201;
        }

        System.out.println("Array with random numbers: " + Arrays.toString(array));

        System.out.println("Max number: " + ArraysUtils.max(array));

        System.out.println("Max positive number: " + ArraysUtils.maxPositive(array));

        System.out.println("Min number: " + ArraysUtils.min(array));

        System.out.println("Array with modulus numbers: " + Arrays.toString(ArraysUtils.modulus(array)));

        System.out.println("Multiply all numbers of array: " + ArraysUtils.multiplication(array));

        System.out.println("Second largest: " + ArraysUtils.secondLargest(array));

        System.out.println("Reverse array: " + Arrays.toString(ArraysUtils.reverse(array)));

        System.out.println("Even numbers array: " + Arrays.toString(ArraysUtils.findEvenElements(array)));

    }
}
