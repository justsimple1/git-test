package ru.job4j.Item;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrackerSingleEagerTest {

    @Test
    public void add() {
        Item item = new Item("Ivan","student",1);
        TrackerSingleEager tracker = TrackerSingleEager.getInstance();
        Item rst = tracker.add(item);
        assertThat((rst.getName()), is("Ivan"));
    }
}