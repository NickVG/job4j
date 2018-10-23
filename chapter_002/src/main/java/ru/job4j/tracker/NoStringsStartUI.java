package ru.job4j.tracker;
import java.lang.*;
import java.util.Arrays;

public class NoStringsStartUI {
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
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public NoStringsStartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("");
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
        String name = this.input.ask("");
        String desc = this.input.ask("");
        Item item = new Item(name, desc);
        this.tracker.add(item);
    }

    /**
     * Метод реализующий вывод всех заявок находящихся в хранилище.
     */
    private void showAllItems() {
        System.out.print(tracker.findAll());
    }

    /**
     * Метод реализующий редактирование заявки.
     */
    private void modifyItem() {
        String taskId = this.input.ask("");
        String taskName = this.input.ask("");
        String taskDescription = this.input.ask("");
        Item newItem = new Item(taskName, taskDescription);
        tracker.replace(taskId, newItem);
    }

    /**
     * Метод реализующий поиск заявки по ID.
     */
    private void findById() {
        String taskId = this.input.ask("");
    }

    /**
     * Метод реализующий поиск заявки по имени.
     */
    private void findByName() {
        String taskName = this.input.ask("");
    }

    /**
     * Метод реализующий удаление заявки.
     */
    private void deleteItem() {
        String taskId = this.input.ask("");
        tracker.delete(taskId);

    }

    private void showMenu() {
    }

    /**
     * Класс StartUI точка входа в программу
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
//        new StartUI(new StubInput(new String[] {"0", "name", "desc", "6"}), new Tracker()).init();
    }

}