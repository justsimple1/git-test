package ru.job4j.array;
/**
 * Таблица умножения.
 * @author NikPanin .
 * @since 10.04.2018 .
 * @version 1 .
 */
public class Matrix {
    /**
     * Реализует таблицу умножения через двумерный массив.
     * @param size - Размер таблицы умножения .
     * @return - возращает значения таблицы.
     */
    int[][] multiple(int size){
        int[][] table = new int[size][size];
        for (int string = 0; string < size; string++){
            for(int cell = 0; cell < size; cell++){
                table[string][cell] = (string + 1)*(cell + 1);
            }
        }
        return table;
    }
}
