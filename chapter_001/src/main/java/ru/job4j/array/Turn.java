package ru.job4j.array;


/**
 * Метод для разворачивания массива
 *
 * @return массив с перевёрнутой последовательностью элементов
 */
public class Turn {
    public int[] turn(int[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[(array.length - i - 1)];
                array[array.length - i - 1] = temp;
            }
        }
        return array;
    }
}
