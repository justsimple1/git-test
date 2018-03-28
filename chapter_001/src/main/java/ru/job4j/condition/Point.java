package ru.job4j.condition;

/**
 * Программа расчитывает расстояние между точками А и B в системе координат.
 * @author NikPanin .
 * @since 28.03.2018 .
 * @version 1.
 */
public class Point{
    /**
     * Cоздание переменных x и y;
     */
    private int x;
    private int y;

    /**
     * Инициализация точек в системе координат.
     * @param x
     * @param y
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Метод расчитывает дистанцию между точками.
     * @param that - Имя переменной черз которую мы на прямую обращаемся к входящей точке B/
     * @return - Дистанция между точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
    /**
     * Главный метод main - реализует Программу для расчёта дистанции.
     * @param args .
     */
    public static void main(String[] args){
        Point a = new Point(-4, -5);
        Point b = new Point(5, 5);
        System.out.println("A distance to B is "+  a.distanceTo(b));
    }
}