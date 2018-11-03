package ru.job4j.tracker;

import java.lang.*;
import java.util.Arrays;

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
     * Константа для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Константа содержащая в себе список меню для пользователя
     */
    private static final StringBuilder MENU = new StringBuilder()
            .append("Меню.").append(System.lineSeparator())
            .append("Для добавления новой заявки введите ").append(ADD).append(System.lineSeparator())
            .append("Для вывода списка всех заявок введите ").append(SHOW).append(System.lineSeparator())
            .append("Для редактирования заявки введите ").append(EDIT).append(System.lineSeparator())
            .append("Для удаления заявки ").append(DELETE).append(System.lineSeparator())
            .append("Для поиска заявки по ID введите ").append(FINDBYID).append(System.lineSeparator())
            .append("Для поиска заявки по имени введите ").append(FINDBYNAME).append(System.lineSeparator())
            .append("Для выхода из программы введите ").append(EXIT).append(System.lineSeparator());

    /**
     * метод возвращающий значение меню для пользователя
     */
    public StringBuilder getMenu() {
        return this.MENU;
    }

    /**
     * Переменная для записи данных выводящихся в консоль
     */

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
     * инициализация логгирования
     */
    Log log = new Log();

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.modifyItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
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
        if (tracker.idEsxists(taskId)) {
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
        if (tracker.idEsxists(taskId)) {
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
        if (tracker.idEsxists(taskId)) {
            System.out.println("------------ Заявка удалена, новое количество имеющихся заявок: " + tracker.idQuantity() + "-----------");
        } else {
            System.out.println("Данный ID не существует, введиет верный ID");
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
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}