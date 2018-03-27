package ru.job4j;

/**
 * Конвертор  валюты.
 * @author Nikita Panin.
 * @since 27.03.2018.
 * @version 1.
 */
public class Converter{
    /**
     * coursDollar - значение курса доллара.
     * coursEuro - значение курса евро.
     */
    double coursDollar = 57.2d;
    double coursEuro =  71.2d;
    /**
     * Перевод рублей в доллары.
     * @param value - сумма в рублях.
     * @return результат.
     */
    public double rubleToDollar(int value) {
        double result = ((double)((int)(value / coursDollar * 100))/100);
        return result;
    }
    /**
     * Перевод рублей в евро.
     * @param value - сумма в рублях.
     * @return результат.
     */
    public double rubleToEuro(int value) {
        double result = ((double)((int)(value / coursEuro * 100))/100);
        return result;
    }
    /**
     * Перевод доллара в рубли.
     * @param value - сумма в долларах.
     * @return результат.
     */
    public double dollarToRuble(int value) {
        double result = (double)((int)(value * coursDollar*100))/100;
        return result;
    }
    /**
     * Перевод евро в рубли.
     * @param value - сумма в евро.
     * @return результат.
     */
    public double euroToRuble(int value) {
        double result = (double)((int)(value * coursEuro*100))/100 ;
        return result;
    }
}

