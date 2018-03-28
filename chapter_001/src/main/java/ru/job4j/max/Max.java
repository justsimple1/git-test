package ru.job4j.max;
/**
 * Программа для поиска максимума из двух чисел.
 * @author NikPanin .
 * @version 1 .
 * @since 28.03.2018 .
 */
public class Max {
    /**
     * Ищет максимум из двух чиселю
     * @param first - Первое число .
     * @param second - Второе число .
     * @return - Максимальное число
     */
    public int max(int first, int second) {
        boolean condition ;
        if(first > second){condition = true;} else {condition = false;}
        return condition ? first:second;
    }
}
