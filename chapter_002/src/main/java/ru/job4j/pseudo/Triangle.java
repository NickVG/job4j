package ru.job4j.pseudo;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+").append('\n');
        pic.append("+++").append('\n');
        pic.append("+++++").append('\n');
        pic.append("+++++++").append('\n');
        return pic.toString();
    }
}