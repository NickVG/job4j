package ru.job4j.loop;

/**
 * @author Nikolay Gorbunov(mailto:krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Метод для вычисления Факториала
     * @param n  - число для которго вычисляется факториал
     * @return Факториал числа n
     */
    public int calc(int n) {
        int factorial = 1;
        if (n > 1) {
            while (n > 1) {
                factorial = n * factorial;
                n--;
            }
        }
        else if(n < 0) factorial = 0;
        return factorial;
    }
}