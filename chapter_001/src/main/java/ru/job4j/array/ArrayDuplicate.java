package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int nullCounter = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = null;
                    nullCounter++;
                }
            }
        }
        if (nullCounter > 0) {
            for (int i = 0; i < array.length - nullCounter; i++) {
                if (!array[i].equals(null)) {
                    array[temp] = array[i];
                    temp++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - nullCounter);
    }


}
