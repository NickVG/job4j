package ru.job4j.test;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayJoinTest {

    @Test
    public void whenA03andB015() {
        ArrayJoin uniter = new ArrayJoin();
        int[] input1 = new int[]{2, 3};
        int[] input2 = new int[]{0, 1, 5};
        int[] result = uniter.unite(input1, input2);
        int[] expect = new int[]{0, 1, 2, 3, 5};
        assertThat(result, is(expect));
    }
}