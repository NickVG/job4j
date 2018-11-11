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
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new CreateItem());
        this.actions.add(new ShowAllItems());  //????
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
            return "Добавление новой заявки.";
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
            System.out.println(Arrays.toString(tracker.findAll()));
            System.out.println();
        }

        @Override
        public String info() {
            return "Показ имеющихся заявок.";
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
                System.out.println("------------ Новое имя заявки: " + newItem.getName() + "-----------");
                System.out.println("------------ Новое описание заявки: " + newItem.getDescription() + "-----------");
                System.out.println("------------ ID заявки: " + newItem.getId() + "-----------");
            } else {
                System.out.println("Данный ID не существует, введите верный ID");
            }
            System.out.println();
        }

        @Override
        public String info() {
            return "Редактирование заявки.";
        }
    }

    /**
     * Класс реализующий поиск заявки по ID.
     */
    public class FindById implements UserAction {
        @Override
        public int key() {
            return Integer.parseInt(SHOW);
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
            return "Поиск заявки по ID.";
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
            return "Поиск заявки по имени.";
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
            return "Удаление заяки.";
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
            return "Удаление из программы.";
        }
    }

}

/*
public class MenuTracker {
    private Input input;
    private  Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
    }
    public void select(int key){
        this.actions[key].execute(this.input,this.tracker);
    }
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }

        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }
    private  static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s", item.getName()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }



}
*/