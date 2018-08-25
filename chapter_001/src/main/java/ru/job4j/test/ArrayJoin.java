package ru.job4j.test;

/**
 * Class ArrayJoin выполняет объёдинение двух массивов.
 *
 * @author nikolay gorbunov
 * Реализация объединения двух массивов,
 * которые предварительно отсортрованы по возрастанию
 */
public class ArrayJoin {
    /**
     * метод реализующий объединение массивов.
     *
     * @param arrayA первый массив
     * @param arrayB второй массив
     * @return массив состоящий из элементов A и B отсортрованных по возрастанию
     * i = индексы первого массива
     * j = индексы второго массива
     * k = индексы результирующего массива
     */
    public final int[] unite(final int[] arrayA, final int[] arrayB) {
        int i = 0, j = 0, k = 0;
        int[] arrayC = new int[arrayA.length + arrayB.length];
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] > arrayB[j]) {
                arrayC[k] = arrayB[j++];
            } else {
                arrayC[k] = arrayA[i++];
            }
            k++;
        }
        while (i < arrayA.length) {
            arrayC[k++] = arrayA[i++];
        }
        while (j < arrayB.length) {
            arrayC[k++] = arrayB[j++];
        }
        return arrayC;
    }
}
