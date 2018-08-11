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
     * @param data - массив, который требуется проверить.
     * @return удовлетворяется ли условие одинковости массивов или нет
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
            for (int i = 0; i < data.length; i++) {
                if (((data[i][i] != data[0][0]) || (data[data.length - 1 - i][i]) != data[0][data.length - 1])) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}