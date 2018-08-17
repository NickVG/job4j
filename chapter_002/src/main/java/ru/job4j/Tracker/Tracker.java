package ru.job4j.Tracker;

public class Tracker {
    private Item[] items = new Item[100];

    /**
     * Метод для добавление заявок
     * @param item
     * @return
     */
    public Item add(Item item){

    }

    /**
     * Метод для редактирования заявок
     * @param id
     * @param item
     */
    public void replace(String id, Item item){

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

    }

    /**
     * Метод для получения списка по имени
     * @param key
     * @return
     */
    public Item[] findByName(String key){

    }

    /**
     * Метод для получения заявки по id
     * @param id
     * @return
     */
    public Item findById(String id){

    }


}

