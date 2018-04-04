package ru.job4j.array;
/**
 * Программа для поиска элемента в массиве.
 * @author NikPanin .
 * @version 1 .
 * @since 05.04.2018 .
 */
    public class FindLoop {
    /**
     * Реализуем поиск элемента в массиве, который удовлетворяет условию.
     * @param data - Массив .
     * @param el - искомый элемент.
     * @return - показывает искомый элемент.
     */
        public int indexOf(int[] data, int el) {
            int rst = -1; // если элемента нет в массиве, то возвращаем -1.
            for (int index = 0; index < data.length; index++) {
                if (data[index] == el) {
                    rst = index;
                    break;
                }
            }
            return rst;
        }
    }

