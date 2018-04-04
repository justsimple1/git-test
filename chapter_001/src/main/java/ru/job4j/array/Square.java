package ru.job4j.array;
 /**
  * Массив с элементами возведёнными в квадрат.
  * @author NikPanin .
  * @version 1 .
  * @since 04.04.2018 .
  */
public class Square {
     /**
      * Метод для реализации массива.
      * @param bound - до какого значения выводить элементы массива.
      * @return - вывод элементов возведённыы в квадрат.
      */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for(int i=1; i <= bound; i++){
            rst[i-1]= i*i;
        }
        return rst;
    }
}
