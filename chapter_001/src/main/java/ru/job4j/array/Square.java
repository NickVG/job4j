package ru.job4j.array;

/**
 * Class Square
 * @author nikolay gorbunov
 * @since 0.0.1
 */
public class Square {
    /**
     * Метод для рисования шахматной доски в псевдографике
     * @param bound размер шахматной доски
     * @return рисунок шахматной доски
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst [i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}