package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 * @author NikPanin .
 * @since 06.06.2018 .
 * @version 1.
 */

public class MatrixCheckTest {
    @Test
    public void whenDiagonalIsMonoByTrueThenTrue(){
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{{true,false,true},{true,true,false},{true,false,true}};
        boolean result = check.mono(input);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    @Test
    public void whenDiagonalIsNotMonoByTrueThenFalse(){
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{{true,false,true},{true,true,true},{false,false,true}};
        boolean result = check.mono(input);
        boolean expected = false;
        assertThat(result,is(expected));
    }
    @Test
    public void whenDiagonalIsMonoByFalseThenTrue(){
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{{false,true,false},{true,false,false},{false,true,false}};
        boolean result = check.mono(input);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    @Test
    public void whenDiagonalIsNotMonoByFalseThenFalse(){
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{{false,false,true},{false,false,false},{false,false,true}};
        boolean result = check.mono(input);
        boolean expected = false;
        assertThat(result,is(expected));
    }

}