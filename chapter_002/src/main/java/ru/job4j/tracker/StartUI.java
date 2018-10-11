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

    public void stop() {
        this.exit = false;
    }

    int[] toIntArray(List<Integer> list) {
        int[] key = new int[list.size()];
        for (int i = 0; i < key.length; i++) {
            key[i] = list.get(i);
        } return key;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        int[] key = toIntArray(range);
        do {
            menu.show();
            menu.select(input.ask("select:", key));
        } while (this.exit);
    }


    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
