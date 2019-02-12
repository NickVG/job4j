package ru.job4j.tracker;

import java.lang.*;

/** Class StartUI
 * Реализация класса StartUI
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.01
 */
public class StartUI {
    private int[] ranges;
    /**
     * Константа содержащая в себе список меню для пользователя
     */
    private static final StringBuilder MENU = new StringBuilder()
            .append("Меню.").append(System.lineSeparator())
            .append("Для добавления новой заявки нажмите ").append(MenuTracker.getADD()).append(System.lineSeparator())
            .append("Для вывода списка всех заявок нажмите ").append(MenuTracker.getSHOW()).append(System.lineSeparator())
            .append("Для редактирования заявки нажмите ").append(MenuTracker.getEDIT()).append(System.lineSeparator())
            .append("Для удаления заявки нажмите ").append(MenuTracker.getDELETE()).append(System.lineSeparator())
            .append("Для поиска заявки по ID нажмите ").append(MenuTracker.getFINDBYID()).append(System.lineSeparator())
            .append("Для поиска заявки по имени нажмите ").append(MenuTracker.getFINDBYNAME()).append(System.lineSeparator())
            .append("Для выхода из программы нажмите ").append(MenuTracker.getEXIT()).append(System.lineSeparator());

    /**
     * метод возвращающий значение меню для пользователя
     */
    public StringBuilder getMenu() {
        return this.MENU;
    }

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        this.ranges = menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт меню.", ranges));
        } while (!"y".equals(this.input.ask("Для выходы из программы нажмите (y). Для продолжения нажмите любую другую клавишу.")));

    }

    /**
     * Класс StartUI точка входа в программу
     * Запуск программы.
     * @param args метод main
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()

                ),
                new Tracker()
        ).init();
    }
}