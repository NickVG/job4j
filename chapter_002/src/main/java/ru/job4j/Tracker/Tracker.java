package ru.job4j.tracker;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
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
        return item;
    }
    /**
     * Метод для получения списка по имени
     * @param key
     * @return
     */
    public Item[] findByName(String key){
        return item;
    }
    /**
     * Метод для получения заявки по id
     * @param id ID заявки
     * @return
     */
    public Item findById(String id){
        return item;
    }


}

