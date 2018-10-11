package ru.job4j.tracker;



public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please enter key in range menu");
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid data again");
            }
        } while (invalid);
        return value;
    }

}
