package ru.job4j.array;
import java.util.Arrays;
/**
 * Удаление дубликатов в массиве.
 * @author NikPanin .
 * @since 11.04.2018 .
 * @version 1 .
 */
public class ArrayDuplicate {
    /**
     * Убирает дупликаты значений, вводимые в массив.
     * @param array - вводимые значения массива.
     * @return - выводимые значения массива, без дупликатов.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for(int out = 0; out < unique; out++){
            for(int in = out + 1; in < unique; in++){
                if(array[out].equals(array[in])){
                    array[in] = array[ unique-1 ];
                    in--;
                    unique--;
                }
            }
        }return Arrays.copyOf(array,unique);
    }
}
