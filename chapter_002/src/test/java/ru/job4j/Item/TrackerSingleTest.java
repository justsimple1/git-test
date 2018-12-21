package ru.job4j.Item;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrackerSingleTest {

    @Test
    public void add() {
        Item item = new Item("Ivan","student",1);
        TrackerSingle tracker = TrackerSingle.INSTANCE;;
        Item rst = tracker.add(item);
        assertThat((rst.getName()), is("Ivan"));
    }
}