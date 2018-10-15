package ru.job4j.pseudo;

public class Painting {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.draw());
    }
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

}
