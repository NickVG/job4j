package ru.job4j.pseudo;

/**
 * Class Square
 * @author nikolay gorbunov
 * Релизация отрисовки квадрата
 */
public class Square implements Shape {

    /**
     *  метод отвечающий за отрисовку квадрата
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        return pic.toString();
    }
}
