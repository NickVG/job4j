package ru.job4j.pseudo;
import java.lang.*;

public class StartUI {

    private final Shape shape;

    /**
     * Класс StartUI точка входа в программу
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        Shape square = new Square();
        Shape triangle = new Triangle();
        new StartUI(square);
        new StartUI(triangle);
    }

    public StartUI(Shape shape) {
        this.shape = shape;
        new Paint().draw(shape);
    }
}