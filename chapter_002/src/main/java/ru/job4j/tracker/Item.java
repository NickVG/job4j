package ru.job4j.tracker;

/** Class Item
 * Реализация класса Item
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String id;
    public String description, name;
    public long create;
    public Item() {
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String name, String desc) {
        setName(name);
        setDescription(desc);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreate() {
        return this.create;
    }

    /**
     * переопределение toString
     * @return содержимое Item
     */
    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", description='" + description + '\''
                + ", name='" + name + '\''
                + ", create=" + create
                + '}';
    }
}
