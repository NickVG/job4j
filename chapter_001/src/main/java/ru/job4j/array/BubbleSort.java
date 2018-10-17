package ru.job4j.array;

/** Class BubbleSort
 * @author nikolay gorbunov
 * Релизация пузрькового метода сортировки массива
 */
public class BubbleSort {

    /**
     *Метод для сортировки элементов массива по возрастанию
     *@param array - масиив который требуется отсортровать.
     */
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i + 1] < array[i]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
}
