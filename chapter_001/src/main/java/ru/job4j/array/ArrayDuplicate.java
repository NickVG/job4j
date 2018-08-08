package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int nullCounter = 0; //Счётчик повторяющихся элементов которым присвоено значение 0
        int temp = 0; //Счётчик элементов массива
        /**
         * внешний цикл используется для перебора всех элементов массива
         */
        for (int i = 0; i < array.length; i++) {
            /**
             * Внутренний цикл. Используется для сравнения выбранного элемента массива
             * с каждым последующим на предмет совпадения значений
             */
            for (int j = i + 1; j < array.length; j++) {
                /**
                 * Если найдено совпадающее значение, то дубликату присваивается значение null
                 */
                if(array[i] != null) {
                    if (array[i].equals(array[j])) {
                        array[j] = null;
                        nullCounter++;
                    }
                }
            }
        }
        /**
         * В случае нахождения дубликатов необходимо сделать перестановки в массиве
         * и затем вренуть массив без дубликатов
         */
        if (nullCounter > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    array[temp] = array[i];
                    temp++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - nullCounter);
    }


}
