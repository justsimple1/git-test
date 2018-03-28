package ru.job4j.max;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author NikPanin .
 * @version 1 .
 * @since 28.03.2018 .
 */
public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(2, 5);
        assertThat(result, is(5));
    }
}
