package ru.job4j.condition;

/**
 * Класс расчёта площади треугольника.
 *
 * @author NikPanin .
 * @version 1 .
 * @since 29.03.2018 .
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    /**
     * Создание трёх точек треугольника.
     * @param a - Первая точка.
     * @param b - Вторая точка.
     * @param c - Третья точка.
     */
    public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
    }
    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b.
     * @param ac расстояние между точками a c.
     * @param bc расстояние между точками b c.
     * @return Полупериметр.
     */
    public double period(double ab, double ac, double bc){
        return (ac + ab + bc)/2;
    }
    /**
     * Проверка возможности построить треугольник по заданным расстояниям между точек.
     *
     * @param ab расстояние между точками a b .
     * @param ac растояние между точками a c .
     * @param bc расстояние между точками b c .
     * @return - Возможно построить или нельзя.
     */
    private boolean exist(double ab, double ac, double bc) {
        if (ab + ac > bc) {
            if (bc + ac > ab) {
                if (ab + bc > ac) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Метод должен вычислить площадь треугольника.
     * @return - Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area(){
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if(this.exist(ab, ac, bc)){
            rsl = Math.sqrt(p*(p-ab)*(p-ac)*(p-bc));
        }
        return rsl;
    }
}

