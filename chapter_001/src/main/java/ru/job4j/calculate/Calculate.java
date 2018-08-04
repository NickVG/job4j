package ru.job4j.calculate;
import java.lang.System;
import static java.lang.System.out;
import ru.job4j.loop.Board;
import ru.job4j.loop.Paint;
import ru.job4j.array.FindLoop;
import ru.job4j.array.Square;

/**
 *Class Calculate решение задачи 1.3 урок 1
 *@author nikolay gorbunov
 *@since 0.0.1
 */
public class Calculate {
	/**
	 *Конструктор, вывод строки Hello world в консоль
	 *@param args - args.
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
		System.out.println(loop.indexOf(rst, 4));

	}
	/**
	 * Method echo.
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}
