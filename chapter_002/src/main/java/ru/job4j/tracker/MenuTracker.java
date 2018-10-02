package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    //private List<UserAction> actions = new ArrayList<>();
    List<UserAction> actions = new ArrayList<>();
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    //===============================================================================================================================
    class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        AddItem(int key, String info) { }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc, 12L);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }

        @Override
        public String info() {
            return "Add new Item.";
        }
    }
    //===============================================================================================================================
    class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] item = tracker.findAll();
            System.out.println("------------Вывод всех заявок --------------");
            for (int i = 0; i < item.length; i++) {
                presentItem(item[i]);
            }
        }

        ShowItems(int key, String info) { }

        @Override
        public String info() {
            return "Show all Item.";
        }

    }
    //===============================================================================================================================
    static class  EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Замена заявки по ID --------------");
            String id = input.ask("Введите ID заявки которую заменяем :");
            Item previous = tracker.findById(id);
            if (previous.equals(null)) {
                System.out.println("Заявка не найдена");
            } else {
                System.out.println("------------ Добавление заявки для замены существующей--------------");
                String name = input.ask("Введите имя заявки :");
                String desc = input.ask("Введите описание заявки :");
                Item next = new Item(name, desc, 12);
                tracker.replace(previous.getId(), next);
                System.out.println("--Заявка изменена--");
            }
        }

        EditItem(int key, String info) { }

        @Override
        public String info() {
            return "Replace this Item.";
        }

    }
    //===============================================================================================================================
    static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------Удаление заявки по ID --------------");
            String id = input.ask("Введите ID заявки :");
            if (tracker.delete(id)) {
                System.out.println("--Заявка удалена--");
            } else {
                System.out.println("Заявка не найдена");
            }
        }

        DeleteItem(int key, String info) { }

        @Override
        public String info() {
            return "Delete this Item.";
        }

    }
    //===============================================================================================================================

    class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------Поиск заявки по ID --------------");
            String id = input.ask("Введите ID заявки :");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявки не найдены");
            } else {
                System.out.println("-------------Искомая заявка-------------");
                presentItem(item);
            }
        }

        FindItemById(int key, String info) { }

        @Override
        public String info() {
            return "Find Item by Id.";
        }

    }
    //===============================================================================================================================
    class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------Поиск заявок по Имени --------------");
            String key = input.ask("Введите Имя заявок :");
            Item[] item = tracker.findByName(key);
            if (item.length == 0) {
                System.out.println("Заявки не найдены");
            } else {
                System.out.println("-------------Искомые заявки-------------");
                for (int i = 0; i < item.length; i++) {
                    presentItem(item[i]);
                }
            }
        }

        FindItemsByName(int key, String info) { }

        @Override
        public String info() {
            return "Find Items by Id.";
        }

    }
    //===============================================================================================================================
    class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------Выход из программы--------------");
        }

        ExitProgram(int key, String info) {
            key = this.key();
            info = this.info();
        }
        @Override
        public String info() {
            return "Exit out program";
        }

    }


    public void presentItem(Item item) {
        System.out.println(item.toString());
    }



}
