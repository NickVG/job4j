package ru.job4j.tracker;
import java.util.Random;
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
     * @return ID заявки
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    int idQuantity () {
        int quantity = 0;
        for (int i = 0; i < 100; i++) {
            if (items[i] != null) {
                quantity++;
            }
        }
        return quantity;
    }
    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item){
        this.position++;
        item.setId(this.generateId());
        return this.items[(position - 1)];
    }
    /**
     * Метод для редактирования заявок
     * @param id    ID заявки
     * @param item  сама новая заявка
     */
    public void replace(String id, Item item){
        findById(id) = item;
    }
    /**
     * Метод для удаления заявок
     * @param id
     */
    public void delete(String id){
    }
    /**
     * Метод для получения списка всех заявок
     * @return
     */
    public Item[] findAll(){
        Item[] result = new Item[idQuantity()];
        int j = 0;
        for (int i = 0; i < 100; i++) {
            if (this.items[i] != null) {
                result[j++] = this.items[i];
            }
        }
        return result;
    }
    /**
     * Метод для получения списка по имени
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
            Item result [] = null;
            for (Item item : items) {
                if (item !=null && item.getId().equals(key)) {
                }
            }
            return result;
    }
    /**
     * Метод для получения заявки по id
     * @param id ID заявки
     * @return result заявка
     */
    public Item findById(String id)
    {
        Item result = null;
        for (Item item : items) {
            if (item !=null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }


}

