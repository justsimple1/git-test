package ru.job4j.tracker;


public class StubInput implements Input {
    private final String[] value;
    private int position = 0;

    public StubInput(String[] value) {
        this.value = value;
    }

    public String ask(String question) {
       return value[this.position++];
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        } if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}