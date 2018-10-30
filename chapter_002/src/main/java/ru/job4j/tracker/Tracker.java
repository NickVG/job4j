package ru.job4j.tracker;

import java.lang.*;
import java.util.*;

/** Class Tracker
 * Реализаци якласса Tracker
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
 */
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
     *@return ID заявки
     */
    private String generateId() {
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
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
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
                item.setId(items[i].getId());
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Метод для удаления заявок
     * @param id
     */
    public void delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, this.position - i - 1);
                position--;
                break;
            }
        }
    }

    /**
     * Метод для получения списка всех заявок
     * @return список всех заявок
     */
    public Item[] findAll() {
        return  Arrays.copyOf(this.items, position);
    }

    /**
     * Метод для получения списка по имени
     * @param key Имя завяки
     * @return список заявок в котором совпадает имя
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int a = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(key)) {
                result[a++] = items[i];
            }
        }
        return Arrays.copyOf(result, a);
    }

    /**
     * Метод для получения заявки по id
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
    /**
     * Метод для проверки существования id
     * @param id ID заявки
     * @return result существует такой id или нет.
     */
    public boolean idEsxists(String id) {
        boolean result = false;
        if(this.position != 0) {
            result = true;
        }
        return result;
    }
}