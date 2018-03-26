package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test
* @author panin.nikita(dla-raboti5@yandex.ru)	
* @version 1
* @since 25.03.2018
*/

public class CalculateTest {
	public void echoMethodVerification() {
	String input = "All right!";
	String expect = "Echo, echo, echo : All right!";
	
	Calculate calc = new Calculate();
	
	String result = calc.echo(input);	
	
	assertThat(result, is(expect));
	}
}