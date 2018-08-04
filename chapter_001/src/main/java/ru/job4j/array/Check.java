package ru.job4j.array;

/**
 * Метод для Проверкина единоообразие массива массива
 *
 * @return массив с перевёрнутой последовательностью элементов
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
       for (int i = 0; i < data.length;  i++) {
            if (data[i] != data [0]) {
                result = false;
                break;
            }
        }
       return result;
    }
}