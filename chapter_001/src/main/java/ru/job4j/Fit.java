package ru.job4j;
/**
 * Программа расчёта идеального веса.
 */

public class Fit {
    /**
     * Коэфициент.
     */
    double coefficient = 1.15;

    /**
     * Расчёт идеального веса для мужчины.
     *
     * @param height - роcт.
     * @return - идеальный вес.
     */
    public double manWeight(int height) {
        double result = (height - 100) * coefficient;
        return result;
    }

    /**
     * Расчёт идеального веса для женщины.
     *
     * @param height - роcт.
     * @return - идеальный вес.
     */
    public double womanWeight(int height) {
        double result = (height - 110) * coefficient;
        return result;
    }
}