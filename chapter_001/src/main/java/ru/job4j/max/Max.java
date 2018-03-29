package ru.job4j.max;
/**
 * Программа для поиска максимума из двух чисел.
 * @author NikPanin .
 * @version 1 .
 * @since 29.03.2018 .
 */
public class Max {
    /**
     * Ищет максимум из трёх чисел через метод поиска максимума из двух чисел.
     * @param first - Первое число .
     * @param second - Второе число .
     * @param third - Третье число .
     * @return - Максимальное число.
     */
    public int max(int first, int second, int third) {
    int temp = this.max(first, second);
    temp = this.max(temp, third);
    return temp;
//
    }
    /**
     * Ищет максимум из двух чисел.
     * @param first - Первое число.
     * @param second - Второе число.
     * @return - Максимальное число.
     */
    public int max(int first, int second) {
        return first  >= second ? first:second;
    }


}
