package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для поиска элемента в массиве.
 * @author NikPanin .
 * @version 1 .
 * @since 05.04.2018 .
 */
    public class FindLoopTest {

        @Test
        public void whenArrayHasLengh35Then4() {
            FindLoop find = new FindLoop();
            int[] input = new int[] {23, 17, 3, 5, 35};
            int value = 35;
            int result = find.indexOf(input, value);
            int expect = 4;
            assertThat(result, is(expect));
        }

        @Test
        public void whenArrayHasntElementThenSub1() {
            FindLoop find = new FindLoop();
            int[] input = new int[] {5, 10, 3};
            int value = 11;
            int result = find.indexOf(input, value);
            int expect = -1;
            assertThat(result, is(expect));
        }
    }


