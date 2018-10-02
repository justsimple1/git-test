package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 21));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNotItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test", "desc", 21));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        String expected = null;
        // проверяем, что нулевой элемент массива в трекере содержит значение null,с введённым ID при эмуляции.
        assertThat(tracker.findById(item.getId()), is(expected));
    }

    @Test
    public void whenDeleteItemButTrackerHasTwoItemsThenTrackerHasOneItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("first", "desc1", 123L));
        //Добавляем ещё заявку
        Item item1 = tracker.add(new Item("second", "desc2", 123L));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит ID элемента с индексным номером 1.
        assertThat(tracker.findAll()[0].getId(), is(item1.getId()));
    }

    StringBuilder menu = new StringBuilder()
            .append("Меню.")            .append(System.lineSeparator())
            .append("0. Add new Item")  .append(System.lineSeparator())
            .append("1. Show all items").append(System.lineSeparator())
            .append("2. Edit item")     .append(System.lineSeparator())
            .append("3. Delete item")    .append(System.lineSeparator())
            .append("4. Find item by Id").append(System.lineSeparator())
            .append("5. Find items by name").append(System.lineSeparator())
            .append("6. Exit Program")   .append(System.lineSeparator())
            .append("Select: ")          .append(System.lineSeparator());

    @Test
    public void whenFoundById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first", "desc1", 123L));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append(menu)
                        .append("Select: ").append(System.lineSeparator())
                        .append("------------Поиск заявки по ID --------------") .append(System.lineSeparator())
                        .append("-------------Искомая заявка-------------")      .append(System.lineSeparator())
                        .append("Имя заявки :" + item.getName() + " ,Описание заявки :" + item.getDesc() + " ,ID этой заявки :" + item.getId()) .append(System.lineSeparator())
                        .append(menu)
                        .toString()
                )
        );

    }

    @Test
    public void whenFoundByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first", "desc1", 123L));
        Input input = new StubInput(new String[] {"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder().append(menu)
                        .append("------------Поиск заявок по Имени --------------") .append(System.lineSeparator())
                        .append("-------------Искомые заявки-------------")      .append(System.lineSeparator())
                        .append("Имя заявки :" + item.getName() + " ,Описание заявки :" + item.getDesc() + " ,ID этой заявки :" + item.getId()) .append(System.lineSeparator())
                        .append(menu)
                        .toString()
                )
        );

    }

    @Test
    public void whenFoundAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first", "desc1", 123L));
        Item item2 = tracker.add(new Item("first2", "desc2", 125L));
        Input input = new StubInput(new String[] {"1",  "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append(menu)
                        .append("------------Вывод всех заявок --------------") .append(System.lineSeparator())
                        .append("Имя заявки :" + item.getName() + " ,Описание заявки :" + item.getDesc() + " ,ID этой заявки :" + item.getId()) .append(System.lineSeparator())
                        .append("Имя заявки :" + item2.getName() + " ,Описание заявки :" + item2.getDesc() + " ,ID этой заявки :" + item2.getId()) .append(System.lineSeparator())
                        .append(menu)
                        .toString()
                )
        );

    }

}