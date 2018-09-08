package ru.job4j.tracker;
/**
 * Realize class Item .
 *
 * @author NikPanin .
 * @since 14.08.18 .
 * @version 1.0 .
 */
public class Item {


    private String name;
    private String desc;
    private long created;
    private String id;

    Item() { }

    /**
     * Конструктор заявки
     *
     * @param name - имя заявки
     * @param desc - описание заявки .

     */
    Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;

    }



    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getCreated() {
        return created ;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
    return "Имя заявки :" + getName() + " ,Описание заявки :" + getDesc() + " ,ID этой заявки :" + getId();
    }
}


