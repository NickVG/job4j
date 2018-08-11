package ru.job4j.converter;

/**
 * Class Converter решение задачи 3.2 урок 1
 * Корвертор валюты
 * @author nikolay gorbunov
 * @since 0.0.1
 */
public class Converter {
    /**
     * USDRUB - курс доллара по отношению к рублю
     * EURRUB - курс евро по отношению к рублю
     */
    private static final int USDRUB = 60;
    private static final int EURRUB = 70;
    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / EURRUB;
    }
    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / USDRUB;
    }
    /**
     * Конвертируем евро в рубли.
     *
     * @param value Евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * EURRUB;
    }
    /**
     * Конвертируем доллары в рубли.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int dollarToRuble(int value) {
        return value * USDRUB;
    }
}