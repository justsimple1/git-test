package ru.job4j.array;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue(){
        Check check = new Check();
        boolean[] input = new boolean [] {true,true,true};
        boolean result = check.mono(input);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    @Test
    public void whenDataNotMonoByTrueThenFalse(){
        Check check = new Check();
        boolean[] input = new boolean [] {true,false,true};
        boolean result = check.mono(input);
        boolean expected = false;
        assertThat(result,is(expected));
    }
    @Test
    public void whenDataMonoByFalseThenTrue(){
        Check check = new Check();
        boolean[] input = new boolean [] {false,false,false,false};
        boolean result = check.mono(input);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    @Test
    public void whenDataNotMonoByFalseThenFalse(){
        Check check = new Check();
        boolean[] input = new boolean [] {false,false,true,false};
        boolean result = check.mono(input);
        boolean expected = false;
        assertThat(result,is(expected));
    }
}