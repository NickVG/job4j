package ru.job4j.calculate;

import java.lang.System;

import static java.lang.System.out;

import ru.job4j.array.ArrayDuplicate;
import ru.job4j.loop.Board;
import ru.job4j.loop.Paint;
import ru.job4j.array.FindLoop;
import ru.job4j.array.Square;
import ru.job4j.array.Turn;


/**
 * Class Calculate тестовый класс для отработки
 *
 * @author nikolay gorbunov
 * @since 0.0.1
 */
public class Calculate {
    /**
     * Конструктор, вывод строки Hello world в консоль
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        System.out.println("Hello world");
//		String name = "Petr";
//		System.out.println(String.format("Hello, %s", name));
//		System.out.println(String.format("Hello, ", name));
//		System.out.println(String.format("Hello, %s MT", name));
//		System.out.println(String.format("x x%s x %sx x%s", name, name, name));
        Board check = new Board();
        System.out.println(check.paint(3, 3));
        Paint pyra = new Paint();
        System.out.println(pyra.pyramid(3));
        FindLoop loop = new FindLoop();
        Square square = new Square();
        int[] rst = square.calculate(3);
//		System.out.println(rst);
        Turn turn = new Turn();
//		System.out.println(turn.turn(rst));
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};//напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        System.out.println(duplicate.remove(array));

        int a = (byte) (-128 - 1);
        System.out.println(a);
        System.out.println(1 + 2 + " " + 3 + 4);
        System.out.println(Math.sqrt(a % 10));

        String name = "Dog";
        change(name);
        System.out.println(name);
        name = change(name);
        System.out.println(name);

        System.out.println(calculate(3));

    }

    public static String change(String name) {
        name = name + "Cat";
        String surname = "Kotov";
        return surname;
    }

    public static int calculate(int a) {
        return a >> 1;
    }

    /**
     * Method echo.
     *
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
