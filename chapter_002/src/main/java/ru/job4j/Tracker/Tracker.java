package ru.job4j.tracker;

import java.lang.*;
import java.util.*;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * метод генерирующий ID заявки
     *
     * @return ID заявки
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод для подсчёта заведённых заявок
     *
     * @return число заведённых заявок
     */
    public int idQuantity() {
        int quantity = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null) {
                quantity++;
            }
        }
        return quantity;
    }

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     * @return item
     */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
    }

    /**
     * Метод для редактирования заявок
     *
     * @param id   ID заявки
     * @param item сама новая заявка
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Метод для удаления заявок
     *
     * @param id
     */
    public void delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, this.position - i - 1);
                position--;
                items[this.position] = null;
            }
        }
    }

    /**
     * Метод для получения списка всех заявок
     *
     * @return
     */
    public Item[] findAll() {
        return  Arrays.copyOf(this.items, position);
    }

    /**
     * Метод для получения списка по имени
     *
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        int j = 0;
        for (Item item : items) {
            if (item.getId().equals(key)) {
                j++;
            }
        }
        Item[] result = new Item[j];
        j = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(key)) {
                System.arraycopy(items, i, result, j, 1);
                j++;
            }
        }
        return result;
    }

    /**
     * Метод для получения заявки по id
     *
     * @param id ID заявки
     * @return result заявка
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);

        System.out.println(Arrays.toString(tracker.findAll()));
        System.out.println(tracker.idQuantity());
        System.out.println(item == null);
    }
}