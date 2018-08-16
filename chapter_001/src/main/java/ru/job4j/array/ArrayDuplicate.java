package ru.job4j.array;
import java.util.Arrays;


/**
 * int counter = 0. Счётчик повторяющихся элементов которым присвоено значение 0
 * int temp = 0 Счётчик уникальных элементов массива
 *  внешний цикл используется для перебора всех элементов массива
 *  Внутренний цикл. Используется для сравнения выбранного элемента массива
 *  с каждым последующим на предмет совпадения значений
 * Если найдено совпадающее значение, то дубликату присваивается значение null
 * Внутренний цикл первого цикла. Используется для сравнения выбранного элемента массива
 * с каждым последующим на предмет совпадения значений
 * Затем проверяется условие того найдены ли дубликаты.
 * В случае нахождения дубликатов необходимо сделать перестановки в массиве
 * и затем вренуть массив без дубликатов
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int counter = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] != null) {
                    if (array[i].equals(array[j])) {
                        array[j] = null;
                        counter++;
                    }
                }
            }
            if (array[i] != null) {
                array[temp] = array[i];
                temp++;
        }
/*        if (counter > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    array[temp] = array[i];
                    temp++;
                }
            }*/
        }
        return Arrays.copyOf(array, array.length - counter);
    }
}
