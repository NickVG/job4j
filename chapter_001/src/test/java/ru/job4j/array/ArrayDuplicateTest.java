package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир", "Мир","Мир", "Маша"};//напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] result =  duplicate.remove(array);
        String[] expect =  {"Привет", "Мир", "Супер", "Маша"};
        assertThat(result, is(expect));
    }
}