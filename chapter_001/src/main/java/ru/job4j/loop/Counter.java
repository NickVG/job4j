package ru.job4j.loop;

/**
 * @author Nikolay Gorbunov(mailto:krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Метод для вычисления суммы четныx чисел в диапазоне от start до finish
     * @param start  - начало диапазона
     * @param finish - конец диапазона
     * @return сумма чётных чисел диапазона
     */
    public int add(int start, int finish) {
        int sum = 0;
        while (start <= finish) {
            if (start % 2 == 0) sum += start;
            start++;
        }
        return sum;
    }
}
