package ru.job4j.Item;

import java.util.Random;

public class TrackerSingleLazy {

    private static TrackerSingleLazy instance;

    private static final Random RANDOM = new Random();
    private final Item[] items = new Item[100];
    private int position = 0;

    public static TrackerSingleLazy getInstance() {
        if(instance == null) {
            instance = new TrackerSingleLazy();
        } return instance;
    }
    // Конструкторы и методы.
    public Item add(Item model) {
        model.setId(this.generateId());
        this.items[this.position++] = model;
        return model;
    }

    private String generateId() {
        return  String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }

    public static void main(String[] args) {
        TrackerSingleLazy tracker = TrackerSingleLazy.getInstance();
        Item item = new Item("name","option",12);
        tracker.add(item);
    }
}