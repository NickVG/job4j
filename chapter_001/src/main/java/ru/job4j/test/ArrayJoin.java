package ru.job4j.test;
import java.util.Arrays;

/**
 * Class ArrayJoin
 * @author nikolay gorbunov
 * Реализация объединения двух массивов, которые предварительно отсортрованы по возрастанию
 */
public class ArrayJoin {
    /**
     * метод реализующий объединение массивов
     * @param A первый массив
     * @param B второй массив
     * @return массив состоящий из элементов A и B отсортрованных по возрастанию
     * i = индексы первого массива
     * j = индексы второго массива
     * temp = индексы результирующего массива
     */
    public int[] unite(int[] A, int[] B) {
        int i = 0, j = 0, temp = 0;
        int[] C = new int[A.length + B.length];
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                C[temp] = B[j];
                j++;
            } else {
                C[temp] = A[i];
                i++;
            }
            temp++;
        }
        if ( i == A.length && j !=B.length) {
            uniteFinish(temp, j, C, B);
        }
        if (i != A.length && j == B.length){
            uniteFinish(temp, i, C, B);
        }
        return C;
    }

    /**
     * Метод для финализации процесса объединения массивов
     * @param arrayIndex текущий индекс массива, который должен получиться по окончании работы класса
     * @param sourceArrayIndex текущий индекс массива который остаётся после сортировки двух массивов
     * @param array массив, который должен получиться по окончании работы класса
     * @param sourceArray массив, который остётся после работы класса
     * @return финальный массив
     */

    public int [] uniteFinish( int arrayIndex, int sourceArrayIndex, int array[], int sourceArray[]) {
        while (sourceArrayIndex < sourceArray.length) {
            array[arrayIndex] = sourceArray[sourceArrayIndex];
            arrayIndex++;
            sourceArrayIndex++;
        }
        return array;
    }
}