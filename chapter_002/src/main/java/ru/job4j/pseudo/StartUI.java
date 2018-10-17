package ru.job4j.pseudo;
import java.lang.*;

public class StartUI {

    /**
     * Класс StartUI точка входа в программу
     * Запуск программы.
     * @param args нет описания
     */
    public static void main(String[] args) {
        Shape square = new Square();
        Shape triangle = new Triangle();
        new StartUI(square);
        new StartUI(triangle);
    }

    private StartUI(Shape shape) {
        new Paint().draw(shape);
    }
}