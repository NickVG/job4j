package ru.job4j.test;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayJoinTest {

    @Test
    public void whenA23andB015() {
        ArrayJoin uniter = new ArrayJoin();
        int[] input1 = new int[]{2, 3};
        int[] input2 = new int[]{0, 1, 5};
        int[] result = uniter.unite(input1, input2);
        int[] expect = new int[]{0, 1, 2, 3, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenA013andB0123568() {
        ArrayJoin uniter = new ArrayJoin();
        int[] input1 = new int[]{0, 1, 3};
        int[] input2 = new int[]{0, 1, 2, 3, 3, 5, 6, 8};
        int[] result = uniter.unite(input1, input2);
        int[] expect = new int[]{0, 0, 1, 1, 2, 3, 3, 3, 5, 6, 8};
        assertThat(result, is(expect));
    }
}