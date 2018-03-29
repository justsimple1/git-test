package ru.job4j.loop;

/**
 * @author NikPanin .
 * @since 29.03.2018 .
 * @version 1.
 */
public class Counter {
    /**
     * Метод высчитывает сумму чётных чисел в заданном диапазоне.
     * @param start Начало диапазона.
     * @param finish Конец диапазона.
     * @return - Сумма всех чётных чисел.
     */
    public int add(int start, int finish) {
        int summ = 0;
        int counter = start;
        for( int i = counter; counter <= finish; counter++){
            if(start % 2 == 0){
               summ += start;
               start ++;
            }else start++;
        } return summ;
    }
}
