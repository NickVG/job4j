package ru.job4j.pseudo;

/**
 * Class Square
 * @author nikolay gorbunov
 * Релизация отрисовки треугольника
 */
public class Triangle implements Shape {

    /**
     *  метод отвечающий за отрисовку треуголника
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+").append(System.lineSeparator());
        pic.append("+++").append(System.lineSeparator());
        pic.append("+++++").append(System.lineSeparator());
        pic.append("+++++++").append(System.lineSeparator());
        return pic.toString();
    }
}