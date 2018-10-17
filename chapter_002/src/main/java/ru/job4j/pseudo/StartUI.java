package ru.job4j.pseudo;
import java.lang.*;
import java.util.Arrays;

public class StartUI {

    /**
     * Класс StartUI точка входа в программу
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Square().draw() + '\n');
        System.out.println(new Triangle().draw() + '\n');
        Triangle p = new Triangle();
        System.out.print(p.draw());
    }
}