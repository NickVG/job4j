package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenSort() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = sorter.sort(input);
        int[] expect = new int[] {1, 2, 4, 6};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenSort() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[] {4, 1, 6, 2, 5};
        int[] result = sorter.sort(input);
        int[] expect = new int[] {1, 2, 4, 5, 6};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithTwoAmountOfElementsThenSort() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[] {6, 5};
        int[] result = sorter.sort(input);
        int[] expect = new int[] {5, 6};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithOneElementThenSort() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[] {6};
        int[] result = sorter.sort(input);
        int[] expect = new int[] {6};
        assertThat(result, is(expect));
    }
}