package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Testing class Tracker .
 *
 * @author NikPanin .
 * @since 14.08.18 .
 * @version 1.0 .
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item();
        Tracker tracker = new Tracker();
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceDescriptionThenReturnNewDescription() {
        Item previous = new Item("Build", "You need 3 truck for three", 12L);
        Tracker tracker = new Tracker();
        tracker.add(previous);
        Item next = new Item("Build", "Complete previous task", 10L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getDesc(), is(next.getDesc()));
    }

    @Test
    public void whenFindByIdThenReturnItemWithThisId() {
        Item item = new Item("Build", "You need 3 truck for three", 12L);
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item next = new Item("Build", "Complete previous task", 10L);
        tracker.add(next);
        assertThat(tracker.findById(next.getId()), is(next));
    }
    @Test
    public void whenDeleteItemByIdThenThisItemIsNull() {
        Item item = new Item("Build", "You need 3 truck for three", 12L);
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.delete(item.getId());
        String exp = null;
        assertThat(tracker.findById(item.getId()), is(exp));
    }
    @Test
    public void whenFindByNameThenReturnItemWithThisName() {
        Item item = new Item("Build", "You need 3 truck for three", 12L);
        Item item2 = new Item("Training", "You need 1 truck for three", 112L);
        Item next = new Item("Build", "Complete previous task", 10L);
        Item next3 = new Item("Playing", "Complete previous task", 10L);
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(next);
        tracker.add(item2);
        tracker.add(next3);
        Item[] exp = {item, next};
        assertThat(tracker.findByName("Build"), is(exp));
    }
    @Test
    public void findAll() {
        Item item = new Item("Bulid", "You need 3 truck for three", 12L);
        Item item2 = new Item("Training", "You need 1 truck for three", 112L);
        Item next = new Item("Build", "Complete previous task", 10L);
        Item next3 = new Item("", "Complete previous task", 10L);
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(next);
        tracker.add(item2);
        tracker.add(next3);
        Item[] exp = {item, next, item2, next3};
        assertThat(tracker.findAll(), is(exp));
        }


    }

