package ru.job4j.tracker;

import java.util.*;
public class MenuTracker {
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
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     * @return длина массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new CreateItem());
        this.actions.add(new ShowAllItems());
        this.actions.add(new MenuTracker.ModifyItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindById());
        this.actions.add(new FindByName());
        this.actions.add(new ExitFromProgramm());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println("Меню");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Класс создания новой заявки
     */
    public class CreateItem implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(ADD);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return ("Для добавления новой заявки нажмите " + ADD);
        }
    }

    /**
     * Класс для показа всех заявок
     */
    public class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(SHOW);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Спиcок всех имеющихся заявок:  --------------");
            Item[] all = tracker.findAll();
            for (Item item : all) {
                System.out.println(item);
            }
            if (all.length == 0) {
                System.out.println("В трекере нет заведённых заявок.");
            }
        }

        @Override
        public String info() {
            return "Для показа всех имеющихся заявок нажмите " + SHOW;
        }
    }

    /**
     * Класс реализующий редактирование заявки.
     */
    public static class ModifyItem implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(SHOW);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование --------------");
            String taskId = input.ask("Введите id заявки котрую требуется заменить : ");
            if (tracker.idEsxists(taskId)) {
                String taskName = input.ask("Введите новое имя заявки : ");
                String taskDescription = input.ask("Введите новое описание заявки : ");
                Item newItem = new Item(taskName, taskDescription);
                tracker.replace(taskId, newItem);
                System.out.println(newItem.toString());
//                System.out.println("------------ Новое имя заявки: " + newItem.getName() + "-----------");
//                System.out.println("------------ Новое описание заявки: " + newItem.getDescription() + "-----------");
//                System.out.println("------------ ID заявки: " + newItem.getId() + "-----------");
            } else {
                System.out.println("Данный ID не существует, введите верный ID");
            }
            System.out.println();
        }

        @Override
        public String info() {
            return "Для редактирования заявки нажмите " + EDIT;
        }
    }

    /**
     * Класс реализующий поиск заявки по ID.
     */
    public class FindById implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(FINDBYID);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID--------------");
            String taskId = input.ask("Введите id заявки котрую требуется найти : ");
            if (tracker.idEsxists(taskId)) {
                System.out.println("------------ ID требуемой заявки: " + tracker.findById(taskId).getId() + "-----------");
            } else {
                System.out.println("Данный ID не существует, введиет верный ID");
            }
            System.out.println();
        }

        @Override
        public String info() {
            return "Для поиски заявки по ID нажмите " + FINDBYID;
        }
    }

    /**
     * Класс реализующий поиск заявки по имени.
     */
    public class FindByName implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(FINDBYNAME);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени--------------");
            String taskName = input.ask("Введите имя заявки котрую требуется найти: ");
            System.out.println("------------ спиcок заявок с совпадающим именем: " + (Arrays.toString(tracker.findByName(taskName))) + "-----------");
            System.out.println();
        }

        @Override
        public String info() {
            return "Для поиска заявки по имени нажмите " + FINDBYNAME;
        }
    }

    /**
     * Класс реализующий удаление заявки.
     */
    public static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(DELETE);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String taskId = input.ask("Введите id заявки котрую требуется удалить : ");
            tracker.delete(taskId);
            if (tracker.idEsxists(taskId)) {
                System.out.println("------------ Заявка удалена, новое количество имеющихся заявок: " + tracker.idQuantity() + "-----------");
            } else {
                System.out.println("Данный ID не существует, введиет верный ID");
            }
            System.out.println();
        }

        @Override
        public String info() {
            return "Для удаления заяки нажмите " + DELETE;
        }
    }

    /**
     * Класс реализующий выход из программы
     */
    public class ExitFromProgramm implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(EXIT);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return "Для выхода из программы нажмите " + EXIT;
        }
    }

}