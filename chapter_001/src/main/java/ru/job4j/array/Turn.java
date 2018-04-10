package ru.job4j.array;
/**
 * Реверсия массива
 * @author NikPanin .
 * @since 10.04.2018
 * @version 1 .
 */
public class Turn {
    /**
     * Реализует реверсию массива.
     * @param array - элементы массива.
     * @return - реверсия элементов массива.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length/2; i ++) {
            int temp = array[i];
            array[i]= array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }return array;
    }
}