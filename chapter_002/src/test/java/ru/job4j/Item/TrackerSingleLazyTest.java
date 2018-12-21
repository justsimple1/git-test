package ru.job4j.Item;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrackerSingleLazyTest {

    @Test
    public void add() {
        Item item = new Item("Ivan","student",1);
        TrackerSingleLazy tracker = TrackerSingleLazy.getInstance();
        Item rst = tracker.add(item);
        assertThat((rst.getName()), is("Ivan"));
    }
}