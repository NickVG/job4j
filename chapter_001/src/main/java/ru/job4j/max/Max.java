package ru.job4j.max;
/**
 * Class Max решение задачи 4.2
 *
 * @author Nikolay Gorbunov
 * @since 0.0.1
 */
public class Max {
    /**
     * метод для поиска максимального числа.
     * @param first - первое сравниваемое целое число
     * @param second - второе сравниваемое целое число
     * @return максимальное значение их двух сравнимаемых чисел
     */
    public int max(int first, int second){
        return (first > second ? first : second);
    }
    public int max(int first, int second, int third){
        return this.max(first, this.max(second, third));
    }
}
