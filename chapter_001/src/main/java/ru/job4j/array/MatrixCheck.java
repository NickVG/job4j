package ru.job4j.array;

/**
 * Class Matrix решение задачи 6.7
 *
 * @author nikolay gorbunov
 * @since 0.0.1
 */

public class MatrixCheck {
    /**
     * Метод для проверки диагональных значений массива на одинаковые значения типа boolean
     *
     * @param data - массив, который требуется проверить.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        if (data.length > 2) {
            for (int i = 0; i < data.length; i++) {
                if (((data[i][i] != data[0][0]) || (data[data.length - 1 - i][data.length - 1 - i]) != data[0][0])) {
                    result = false;
                    break;
                }
            }
        }
        if (data.length == 2) {
            result = (data[0][0] == data[1][1]);
            result = (data[1][0] == data[0][1]);
        }
        return result;
    }
}