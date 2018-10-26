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
     * Переменная для записи данных выводящихся в консоль
     */
    private String log  = "";

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
     * Метод для получения текстовых данных выводящихся в консоль во время работы программы
     * @return MENU
     */
    public String getlog() {
        return this.log;
    }

    private void setlog(String log) {
        this.log += log;
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
        System.out.println();
    }

    /**
     * Метод реализующий вывод всех заявок находящихся в хранилище.
     */
    private void showAllItems() {
        System.out.println("------------ Спиcок всех имеющихся заявок:  --------------");
        setlog("------------ Спиcок всех имеющихся заявок:  --------------" + System.lineSeparator());
        System.out.println(Arrays.toString(tracker.findAll()));
        setlog(Arrays.toString(tracker.findAll()) + System.lineSeparator());
        System.out.println();
        setlog(System.lineSeparator());
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
        System.out.println();
    }

    /**
     * Метод реализующий поиск заявки по ID.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по ID--------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется найти : ");
        System.out.println("------------ ID требуемой заявки: " + tracker.findById(taskId).getId() + "-----------");
        System.out.println();
    }

    /**
     * Метод реализующий поиск заявки по имени.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени--------------");
        setlog("------------ Поиск заявки по имени--------------" +  System.lineSeparator());
        String taskName = this.input.ask("Введите имя заявки котрую требуется найти : ");
        setlog("Введите имя заявки котрую требуется найти : " + System.lineSeparator());
        System.out.println("------------ спиcок заявок с совпадающим именем: " + (Arrays.toString(tracker.findByName(taskName))) + "-----------");
        setlog("------------ спиcок заявок с совпадающим именем: " + (Arrays.toString(tracker.findByName(taskName))) + "-----------" + System.lineSeparator());
        System.out.println();
        setlog(System.lineSeparator());
    }

    /**
     * Метод реализующий удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String taskId = this.input.ask("Введите id заявки котрую требуется удалить : ");
        tracker.delete(taskId);
        System.out.println("------------ Заявка удалена, новое количество имеющихся заявок: " + tracker.idQuantity() + "-----------");
        System.out.println();
    }

    /**
     * Метод для отображения списка меню
     */
    private void showMenu() {
        Log.stringLog("Меню.");
        //        System.out.println("Меню.");
//        setlog("Меню." + System.lineSeparator());
        System.out.println("Для добавления новой заявки введите " + ADD);
        setlog(log += "Для добавления новой заявки введите " + ADD + System.lineSeparator());
        System.out.println("Для вывода списка всех заявок введите " + SHOW);
        setlog("Для вывода списка всех заявок введите " + SHOW + System.lineSeparator());
        System.out.println("Для редактирования заявки введите " + EDIT);
        setlog("Для редактирования заявки введите " + EDIT + System.lineSeparator());
        System.out.println("Для удаления заявки " + DELETE);
        setlog("Для удаления заявки " + DELETE + System.lineSeparator());
        System.out.println("Для поиска заявки по ID введите " + FINDBYID);
        setlog("Для поиска заявки по ID введите " + FINDBYID + System.lineSeparator());
        System.out.println("Для поиска заявки по имени введите " + FINDBYNAME);
        setlog("Для поиска заявки по имени введите " + FINDBYNAME + System.lineSeparator());
        System.out.println("Для выхода из программы введите " + EXIT);
        setlog("Для выхода из программы введите " + EXIT + System.lineSeparator());
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