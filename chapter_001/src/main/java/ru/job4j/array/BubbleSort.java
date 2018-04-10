package ru.job4j.array;
/**
 * Сортировка массива методом пузырька.
 * @author NikPanin .
 * @version 1.
 * @since 10.04.2018 .
 */
public class BubbleSort {
    /**
     * Cортировка массива методом перестановки .
     * @param array - вводимые элемеиты массива.
     * @return - отсортированные элементы массива.
     */
    public int[] sort(int[] array) {
        for(int string = array.length-1; string > 0; string--){
            for(int index = 0; index < string ; index++){
                if(array[index] > array[index + 1]){
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }return array;
    }

}
