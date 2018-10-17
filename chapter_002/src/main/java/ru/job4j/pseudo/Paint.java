package ru.job4j.pseudo;

import java.lang.*;

/**
 * Class Paint
 * @author nikolay gorbunov
 * Релизация формирования строки в псевдографике
 */
public class Paint {
    /**
     * метод формирующий строку в псевдографике
     * @param shape
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}