package ru.job4j.tracker;

import java.util.Random;

public class StartUI  {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для редактированмя заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для вывода заявки по введённому ID.
     */
    private static final String ID = "4";
    /**
     * Константа меню для вывода заявки по введённому Имени.
     */
    private static final String NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            }  else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (SHOWALL.equals(answer)) {
                this.showItem();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (ID.equals(answer)) {
                this.findItemById();
            } else if (NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 12);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void editItem() {
        System.out.println("------------ Замена заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки которую заменяем :");
        Item previous = tracker.findById(id);
        if (previous.equals(null)) {
            System.out.println("Заявка не найдена");
        } else {
            System.out.println("------------ Добавление заявки для замены существующей--------------");
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            Item next = new Item(name, desc, 12);
            tracker.replace(previous.getId(), next);
            System.out.println("--Заявка изменена--");
        }
    }
    private void showItem() {
        Item[] item = this.tracker.findAll();
        System.out.println("------------Вывод всех заявок --------------");
        for (int i = 0; i < item.length; i++) {
            presentItem(item[i]);
        }
    }
    private void delete() {
        System.out.println("------------Удаление заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        if (tracker.findById(id).equals(null)) {
            System.out.println("Заявка не найдена");
        } else {
            this.tracker.delete(id);
            System.out.println("--Заявка удалена--");
        }
    }
    private void findItemById() {
        System.out.println("------------Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявки не найдены");
        } else {
            System.out.println("-------------Искомая заявка-------------");
            presentItem(item);
        }
    }
    private void findItemByName() {
        System.out.println("------------Поиск заявок по Имени --------------");
        String key = this.input.ask("Введите Имя заявок :");
        Item[] item = tracker.findByName(key);
        if (item == null) {
            System.out.println("Заявки не найдены");
        } else {
            System.out.println("-------------Искомые заявки-------------");
            for (int i = 0; i < item.length; i++) {
                presentItem(item[i]);
            }
        }
    }
    private void showMenu() {
        System.out.println("Меню." + "\n0. Add new Item" +  "\n1. Show all items" + "\n2. Edit item" + "\n3. Delete item");
        System.out.println("4. Find item by Id" + "\n5. Find items by name" + "\n6. Exit Program" + "\nSelect");
    }
    /**
     * Запускт программы.
     * @param
     */

    public void presentItem(Item item) {
        System.out.println("Имя заявкм :" + item.getName());
        System.out.println("Описание заявкм :" + item.getDesc());
        System.out.println("ID этой заявкм :" + item.getId());
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
