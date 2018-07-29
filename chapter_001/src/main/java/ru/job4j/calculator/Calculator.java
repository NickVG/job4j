package ru.job4j.calculator;

/**
 *Class Calculator решение задачи 3.1 урок 1
 *@author nikolay gorbunov
 *@since 0.0.1
 */
public class Calculator {

    /**
     *
     */
    private double result;
    /**
     *Метод сложения двух чисел для модели
     *Метод сложения двух чисел для модели
     *простейшего калькулятора
     * @param first - первое введённое число
     * @param second - второе введённое число
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
//div
    /**
     *Метод вычитания двух чисел для модели
     *простейшего калькулятора
     * @param first - первое слагаемое
     * @param second - второе слагаемое
     */
    public void subtract(double first, double second) {
    this.result = first - second;
}
    /**
     *Метод деления одного число на другое для модели
     *простейшего калькулятора
     * @param first - первое введённое число, делитель
     * @param second - второе введённое число, знаменатель
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     *Метод умножения одного число на другое для модели
     *простейшего калькулятора
     * @param first - первый множитель
     * @param second - второй множитель
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     * @return this.result.
     */
    public double getResult() {
        return this.result;
    }
}