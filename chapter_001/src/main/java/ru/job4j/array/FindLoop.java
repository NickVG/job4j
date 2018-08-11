package ru.job4j.array;
    /**
    *Class FindLoop
    *@author nikolay gorbunov
    *@since 0.0.1
    */
public class FindLoop {
    /**
     * Метод для посика индекса элеиента массива попадающего под условие поиска
     * @param data массив который в котором проводится поиск требуемого значения
     * @param el значение которе требуется найти
     * @return индекс элемента
     * В переменной rst1 хранится возвращаемое значение
     * если элемента нет в массиве, то возвращаем -1.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}

