package ru.job4j.array;

/**
 * Class Square
 * @author nikolay gorbunov
 * @since 0.0.1
 */
public class Turn {
    /**
     * Метод для разворачивания массива
     * @param array масств который требуется проверить
     * @return массив с перевёрнутой последовательностью элементов
     */
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
