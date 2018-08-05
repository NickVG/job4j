package ru.job4j.array;

/**
 *Class Matrix решение задачи 6.7
 *@author nikolay gorbunov
 *@since 0.0.1
 */

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}