package ru.job4j.condition;

/**
 * @author Nikolay Gorbunov(mailto:krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Point {
	 private int x;
	 private int y;
    /**
     * Метод для задания координат.
     * @param x Координта по оси X.
     * @param y Координта по оси Y.
     */
	 public Point(int x, int y) {
		  this.x = x;
		  this.y = y;
	 }
    /**
     * Расчёт расстояния между точками.
     * @param that удалнная точка
     * @return расстояние между точками.
     */
	public double distanceTo(Point that) {
		return Math.sqrt(
				Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
		);
	}
	/**
	 *Расчёт расстояния между точками,
	 *задание координат через метод Point
	 *вывод координат в консоль через System.out.println
	 *@param args - args.
	 */
	public static void main(String[] args) {
	Point a = new Point(0, 1);
	Point b = new Point(0, 10);
	System.out.println("x1 = " + a.x);
	System.out.println("y1 = " + a.y);
	System.out.println("x2 = " + b.x);
	System.out.println("y2 = " + b.y);
	double result = a.distanceTo(b);
	System.out.println("Расстояние между точками А и В : " + result);
	}
}