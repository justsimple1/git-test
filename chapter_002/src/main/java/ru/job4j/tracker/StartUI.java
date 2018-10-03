package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartUI  {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    private boolean exit = true;


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

    public void stop(){
        this.exit = false;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask(String.valueOf("select:" + range))));
//        } while (!this.exit.equals(this.input.ask("Exit?(y): ")));
        } while (this.exit);
    }

    private void showMenu() {

        System.out.println("Меню." + System.lineSeparator() + "0. Add new Item" + System.lineSeparator() + "1. Show all items" + System.lineSeparator() + "2. Edit item" + System.lineSeparator() + "3. Delete item");
        System.out.println("4. Find item by Id" + System.lineSeparator() + "5. Find items by name" + System.lineSeparator() + "6. Exit Program" + System.lineSeparator() + "Select: ");
    }




    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
