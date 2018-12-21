package ru.job4j.Item;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleInsideLazyTest {

    @Test
    public void add() {
        Item item = new Item("Ivan","student",1);
        TrackerSingleInsideLazy tracker = TrackerSingleInsideLazy.getInstance();
        Item rst = tracker.add(item);
        assertThat((rst.getName()), is("Ivan"));
    }
}