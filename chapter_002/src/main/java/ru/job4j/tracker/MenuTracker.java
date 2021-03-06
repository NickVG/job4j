package ru.job4j.tracker;

import java.util.*;

/**
 * Class MenuTracker
 * Реализация класса MenuTracker
 *
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;
    /**
     * Константа для Показа всех заявок.
     */
    private static final int SHOW = 1;
    /**
     * Константа для редактирования заявки.
     */
    private static final int EDIT = 2;
    /**
     * Константа для удаления заявки
     */
    private static final int DELETE = 3;
    /**
     * Константа для поиска заявки по ID.
     */
    private static final int FINDBYID = 4;
    /**
     * Константа для поиска заявки по имени.
     */
    private static final int FINDBYNAME = 5;
    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;
    /**
     * @param хранит ссылку на объект Input.
     */
    private Input input;
    /**
     * @param хранит ссылку на объект Tracker.
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Метод для получения значения меню для добавления новой заявки.
     */
    public static int getADD() {
        return ADD;
    }

    /**
     * Метод для получения значения меню для показа всех заявок.
     */
    public static int getSHOW() {
        return SHOW;
    }

    /**
     * Метод для получения значения меню для редактирования заявки.
     */
    public static int getEDIT() {
        return EDIT;
    }

    /**
     * Метод для получения значения меню для удаления заявки.
     */
    public static int getDELETE() {
        return EXIT;
    }

    /**
     * Метод для получения значения меню для поиска заявки по ID.
     */
    public static int getFINDBYID() {
        return FINDBYID;
    }

    /**
     * Метод для получения значения меню для поиска заявки по имени.
     */
    public static int getFINDBYNAME() {
        return FINDBYNAME;
    }

    /**
     * Метод для получения значения меню для выхода из цикла.
     */
    public static int getEXIT() {
        return EXIT;
    }

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
     *
     * @return длина массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив, а также возвращает массив с диапазоном возможных вариатов вызова меню
     */
    public int[] fillActions() {
        this.actions.add(new CreateItem());
        this.actions.add(new ShowAllItems());
        this.actions.add(new MenuTracker.ModifyItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindById());
        this.actions.add(new FindByName());
        this.actions.add(new ExitFromProgramm());
        int[] range = new int[getActionsLength()];
        for (int i = 0; i < getActionsLength(); i++) {
            range[i] = i;
        }
        return range;
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции(пункт меню, который требуется выбрать)
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println("Меню.");
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
            return ADD;
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
            return SHOW;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Спиcок всех имеющихся заявок:  --------------");
            Item[] all = tracker.findAll();
            for (Item item : all) {
                System.out.println(item);
            }
            if (all.length == 0) {
                System.out.println("В трекере не существует ни одной заведённой заявки.");
            }
        }

        @Override
        public String info() {
            return "Для вывода списка всех заявок нажмите " + SHOW;
        }
    }

    /**
     * Класс реализующий редактирование заявки.
     */
    public static class ModifyItem implements UserAction {
        @Override
        public int key() {
            return SHOW;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.idQuantity() != 0) {
                System.out.println("------------ Редактирование --------------");
                String taskId = input.ask("Введите id заявки котрую требуется заменить : ");
                if (tracker.idExists(taskId)) {
                    Item itemToChange = tracker.findById(taskId);
                    tracker.replace(taskId, itemToChange);
                    String taskName = input.ask("Введите новое имя заявки : ");
                    String taskDescription = input.ask("Введите новое описание заявки : ");
                    Item newItem = new Item(taskName, taskDescription);
                    tracker.replace(taskId, newItem);
                    System.out.println(newItem.toString());
                } else {
                    System.out.println("Введённый ID не существует");
                }
            } else {
                System.out.println("В трекере не существует ни одной заведённой заявки");
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
            return FINDBYID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.idQuantity() != 0) {
                System.out.println("------------ Поиск заявки по ID--------------");
                String taskId = input.ask("Введите id заявки котрую требуется найти : ");
                Item item = tracker.findById(taskId);
                if (item != null) {
                    System.out.println("------------ Требуемая заявка: " + item.toString() + "-----------");
                } else {
                    System.out.println("Данный ID не существует, введите верный ID");
                }
            } else {
                System.out.println("В трекере не существует ни одной заведённой заявки");
            }
            System.out.println();
        }

        @Override
        public String info() {
            return "Для поиска заявки по ID нажмите " + FINDBYID;
        }
    }

    /**
     * Класс реализующий поиск заявки по имени.
     */
    public class FindByName implements UserAction {
        @Override
        public int key() {
            return FINDBYNAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.idQuantity() != 0) {
                System.out.println("------------ Поиск заявки по имени--------------");
                String taskName = input.ask("Введите имя заявки котрую требуется найти: ");
                Item[] items = tracker.findByName(taskName);
                if (items != null) {
                    System.out.println("------------ спиcок заявок с совпадающим именем: " + (Arrays.toString(tracker.findByName(taskName))) + "-----------");
                } else {
                    System.out.println("В трекере не существует заведённых заявок c таким именем");
                }
            } else {
                System.out.println("В трекере не существует ни одной заведённой заявки");
            }
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
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.idQuantity() != 0) {
                System.out.println("------------ Удаление заявки --------------");
                String taskId = input.ask("Введите id заявки котрую требуется удалить : ");
                if (tracker.delete(taskId)) {
                    System.out.println("------------ Заявка удалена, новое количество имеющихся заявок: " + tracker.idQuantity() + "-----------");
                } else {
                    System.out.println("Данный ID не существует, введите верный ID");
                }
            } else {
                System.out.println("В трекере не существует ни одной заведённой заявки");
            }
            System.out.println();
        }

        @Override
        public String info() {
            return "Для удаления заявки нажмите " + DELETE;
        }
    }

    /**
     * Класс реализующий выход из программы
     */
    public class ExitFromProgramm implements UserAction {
        @Override
        public int key() {
            return EXIT;
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