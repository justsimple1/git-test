package ru.job4j.loop;

import java.util.function.BiPredicate;
/**
 * Создание пирамиды по заданной высоте.
 * @author NikPanin .
 * @version 1 .
 * @since 31.03.2018.
 */

    public class Paint{
    /**
     * Рисуем пирамиду по заданной высоте.
     * @param height - высота пирамиды.
     * @return - возращает все строки пирамиды.
     */
        public String rightTrl(int height) {
            return this.loopBy(
                    height,
                    height,
                    (row, column) -> row >= column
            );
        }

        public String leftTrl(int height) {
            return this.loopBy(
                    height,
                    height,
                    (row, column) -> row >= height - column - 1
            );
        }

        public String pyramid(int height) {
            return this.loopBy(
                    height,
                    2 * height - 1,
                    (row, column) -> row >= height - column - 1 && row + height - 1 >= column
            );
        }

        private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
            StringBuilder screen = new StringBuilder();
            for (int row = 0; row != height; row++) {
                for (int column = 0; column != weight; column++) {
                    if (predict.test(row, column)) {
                        screen.append("^");
                    } else {
                        screen.append(" ");
                    }
                }
                screen.append(System.lineSeparator());
            }
            return screen.toString();
        }
    }

