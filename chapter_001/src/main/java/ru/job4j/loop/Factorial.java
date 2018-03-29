package ru.job4j.loop;

/**
 *  Факториал числа.
 * @author NikPanin .
 * @since 30.03.2018 .
 * @version 1 .
 */
public class Factorial {
    /**
     * Расчёт факториала числа.
     * @param n - Число для расчёта.
     * @return - Факториал числа
     */
    public int calc(int n){
        int mult = 1;
        for(int i = 1; i <= n; i++){
            if(n!=0){
            mult *= i;
        }else
            {mult = 1;}
        } return mult;

    }
}
