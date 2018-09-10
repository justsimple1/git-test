package ru.job4j.strategy;

public class Square implements Shape{

    @Override
    public String draw() {
        StringBuilder x = new StringBuilder();
        x.append("  ++++ ");
        x.append("+      +");
        x.append("+      +");
        x.append("  ++++ ");
        return x.toString();
    }
}

