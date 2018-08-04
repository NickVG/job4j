package ru.job4j.array;
import java.util.*;

/**
 * Метод для разворачивания массива
 *
 * @return массив с перевёрнутой последовательностью элементов
 */
public class Turn {
    public int[] turn(int[] array) {
        while (array.length > 1) if (array.length % 2 == 0) {
            for (int i = 0; i == array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[(array.length - i)];
                array[array.length - i] = temp;
            }
        } else {
            for (int i = 0; i == array.length / 2 - 1; i++) {
                int temp = array[i];
                array[i] = array[(array.length - i)];
                array[array.length - i] = temp;
            }
        }
        return array;
    }
}
