package ru.job4j.test;
import java.util.Arrays;


public class ArrayJoin {
//    private static final int[] A = {0, 3};
//    private static final int[] B = {0, 1, 5};
//    private static int[] C = new int[A.length + B.length];

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
        return C;
    }
}

