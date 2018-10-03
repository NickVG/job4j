package ru.job4j.tracker;
import java.lang.*;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для Показа всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа для удаления заявки
     */
    private static final String DELETE = "3";
    /**
     * Константа для поиска заявки по ID.
     */
    private static final String FINDBYID = "4";
    /**
     *  Константа для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Класс StartUI точка входа в программу
     */

    public static void main(String[] args){
        ConsoleInput input = new ConsoleInput();
        String name = input.ask ("Please, enter the task's name: ");
        Tracker tracker = new Tracker();
        tracker.add(new Task("first Task", "first Description"));
        for (Item item: tracker.findAll()) {
            System.out.println(item.getName());
        }
//        boolean exit = false;
/*        while(exit) {
            if (...) {
            } else if (...) {
            }
        } */
    }
}