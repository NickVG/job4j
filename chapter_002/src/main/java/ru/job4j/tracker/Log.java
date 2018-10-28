package ru.job4j.tracker;

public class Log {
    StringBuilder log = new StringBuilder();;

    public void stringLog(String string) {
        System.out.println(string);
        this.log.append(string).append(System.lineSeparator());
    }

    public StringBuilder getlog() {
        return this.log;
    }
}
