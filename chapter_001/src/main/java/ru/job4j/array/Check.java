package ru.job4j.array;

public class Check {
    public boolean mono(boolean data[]) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if(data[data.length-1]!= data[i]){
                result = false;
                break;
            }result = true;
        }return result;
    }
}