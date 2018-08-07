package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};//напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] result =  duplicate.remove(array);
        String[] expect =  {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));
    }
}
/*
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }
}

        BubbleSort sorter = new BubbleSort();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = sorter.sort(input);
        int[] expect = new int[] {1, 2, 4, 6};
        assertThat(result, is(expect));
        */