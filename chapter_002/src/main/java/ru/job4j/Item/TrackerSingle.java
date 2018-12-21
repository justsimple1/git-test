package ru.job4j.Item;


import java.util.Random;

public enum TrackerSingle {
    INSTANCE; // здесь мы указываем перечисления.
    private static final Random RANDOM = new Random();
    private final Item[] items = new Item[100];
    private int position = 0;

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
        TrackerSingle tracker = TrackerSingle.INSTANCE;
        Item item = new Item("name","option",12);
        tracker.add(item);
    }
}