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
    public StartUI(Input input, Tracker tracker) {
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
    }

    /**
     * Метод реализующий вывод всех заявок находящихся в хранилище.
     */
    private void showAllItems() {
        System.out.println("------------ Спиcок всех имеющихся заявок:  --------------");
        System.out.println(Arrays.toString(tracker.findAll()));
    }

    /**
     * Метод реализующий редактирование заявки.
     */
    private void modifyItem() {
        System.out.println("------------ Редактирование --------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется заменить : ");
        String taskName = this.input.ask("Введите имя заявки : ");
        String taskDescription = this.input.ask("Введите описание заявки : ");
        Item newItem = new Item(taskName, taskDescription);
        tracker.replace(taskId, newItem);
        System.out.println("------------ Новое имя заявки: " + newItem.getName() + "-----------");
        System.out.println("------------ Новое описание заявки: " + newItem.getDescription() + "-----------");
        System.out.println("------------ ID заявки: " + newItem.getId() + "-----------");
    }

    /**
     * Метод реализующий поиск заявки по ID.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по ID--------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется найти : ");
        System.out.println("------------ ID требуемой заявки: " + tracker.findById(taskId).getId() + "-----------");
    }

    /**
     * Метод реализующий поиск заявки по имени.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени--------------");
        String taskName = this.input.ask("Введите имя заявки котрую требуется найти : ");
        System.out.println("------------ спиcок заявок с совпадающим именем: " + (Arrays.toString(tracker.findByName(taskName))) + "-----------");
    }

    /**
     * Метод реализующий удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется удалить : ");
        tracker.delete(taskId);
        System.out.println("------------ Заявка удалена, новое количество имеющихся заявок: " + tracker.idQuantity() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("Для добавления новой заявки введите " + ADD);
        System.out.println("Для вывода списка всех заявок введите " + SHOW);
        System.out.println("Для редактирования заявки введите " + EDIT);
        System.out.println("Для удаления заявки " + DELETE);
        System.out.println("Для поиска заявки по ID введите " + FINDBYID);
        System.out.println("Для поиска заявки по имени введите " + FINDBYNAME);
        System.out.println("Для выхода из программы введите " + EXIT);
        // добавить остальные пункты меню.
    }

    /**
     * Класс StartUI точка входа в программу
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}