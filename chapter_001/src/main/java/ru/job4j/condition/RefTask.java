package ru.job4j.condition;

public class RefTask {
    public static void main(String[] args) {
        int value = 1;
        RefTask.change(value);
        System.out.print(value);
        ++value;
        System.out.println(value);
    }

    public static void change(Integer value) {
        ++value;
    }
}