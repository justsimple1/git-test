package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Realize class Tracker .
 *
 * @author NikPanin .
 * @since 14.08.18 .
 * @version 1.0 .
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private static final Random RANDOM = new Random();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод реализаущий замену существующей заявки в хранилище по Id на новую заявку .
     * @param id - уникальныый идентификатор заявки .
     * @param item новая заявка на которую заменяем старую заявку .
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
            }
        }return result;
    }
    /**
     * Метод реализаущий удаление заявки по его Id .
     * @param id - уникальныый идентификатор заявки .
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                System.arraycopy(items, (index + 1), items, index, (items.length - index - 1));
                position--;
                result = true;
                break;
            }
        }return result;
    }
    /**
     * Метод реализаущий поиск заявок по имени .
     * @param key - Вводимое имя .
     * @return - массив заявок с искомым именем .
     */
    public Item[] findByName(String key) {
        Item[] rst = new Item[position];
        int index = 0;
        for (int i = 0; i < position; i++) {
            if (key.equals(items[i].getName())) {
                rst[index] = items[i];
                index++;
            }
        }
           return Arrays.copyOf(rst, index);
    }
    /**
     * Метод реализаущий поиск заявки по его Id .
     * @param id - уникальныый идентификатор заявки .
     */
    public Item findById(String id) {
        Item rst = null;
            for (int i = 0; i < position; i++) {
                if (items[i] != null && items[i].getId().equals(id)) {
                   rst = items[i];
                   break;
                }
            }
        return rst;
    }
    /**
     * Метод реализаущий вывод всех заявок существующих в хранилище .
     * @return rst - массив со всеми заявками .
     */
//    public Item[] findAll() {
//        Item[] rst = new Item[position];
//        for (int index = 0; index < position; index++) {
//            if (items[index] != null) {
//                rst[index] = items[index];
//            }
//        } return rst;
//    }
    public Item[] findAll() {
    return Arrays.copyOf(this.items, this.position); }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
     return  String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }
}