package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner input = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return input.nextLine();
    }
}
