package ru.job4j.tracker;

import java.lang.*;
import java.util.Arrays;
import java.util.*;

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
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        this.ranges = new int[menu.getActionsLength()];
        for (int i = 0; i < menu.getActionsLength(); i++) {
            this.ranges[i] = i;
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт меню.", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));

    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        System.out.println();
    }

    /**
     * Метод реализующий вывод всех заявок находящихся в хранилище.
     */
    private void showAllItems() {
        System.out.println("------------ Спиcок всех имеющихся заявок:  --------------");
        System.out.println(Arrays.toString(tracker.findAll()));
        System.out.println();
    }

    /**
     * Метод реализующий редактирование заявки.
     */
    private void modifyItem() {
        System.out.println("------------ Редактирование --------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется заменить : ");
        if (tracker.idExists(taskId)) {
            String taskName = this.input.ask("Введите новое имя заявки : ");
            String taskDescription = this.input.ask("Введите новое описание заявки : ");
            Item newItem = new Item(taskName, taskDescription);
            tracker.replace(taskId, newItem);
            System.out.println("------------ Новое имя заявки: " + newItem.getName() + "-----------");
            System.out.println("------------ Новое описание заявки: " + newItem.getDescription() + "-----------");
            System.out.println("------------ ID заявки: " + newItem.getId() + "-----------");
        } else {
            System.out.println("Данный ID не существует, введите верный ID");
        }
        System.out.println();
    }

    /**
     * Метод реализующий поиск заявки по ID.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по ID--------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется найти : ");
        if (tracker.idExists(taskId)) {
            System.out.println("------------ ID требуемой заявки: " + tracker.findById(taskId).getId() + "-----------");
        } else {
            System.out.println("Данный ID не существует, введиет верный ID");
        }
        System.out.println();
    }

    /**
     * Метод реализующий поиск заявки по имени.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени--------------");
        String taskName = this.input.ask("Введите имя заявки котрую требуется найти: ");
        System.out.println("------------ спиcок заявок с совпадающим именем: " + (Arrays.toString(tracker.findByName(taskName))) + "-----------");
        System.out.println();
    }

    /**
     * Метод реализующий удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется удалить : ");
        tracker.delete(taskId);
        if (tracker.idExists(taskId)) {
            System.out.println("------------ Заявка удалена, новое количество имеющихся заявок: " + tracker.idQuantity() + "-----------");
        } else {
            System.out.println("Данный ID не существует, введите верный ID");
        }
        System.out.println();
    }

    /**
     * Метод для отображения списка меню
     */
    private void showMenu() {
        System.out.print(getMenu());
    }

    /**
     * Класс StartUI точка входа в программу
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(MenuTracker.getADD());
//        new StartUI(new ConsoleInput(), new Tracker()).init();
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}