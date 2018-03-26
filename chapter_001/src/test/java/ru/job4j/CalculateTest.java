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

	@Test
	public void whenAdd1Plus1Then2() {
		Calculate calc = new Calculate();
		calc.add(1D,1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}

	@Test
	public void whenSub7On2Then5() {
		Calculate calc = new Calculate();
		calc.sub(7D,2D);
		double result = calc.getResult();
		double expected = 5D;
		assertThat(result, is(expected));
	}

	@Test
	public void whenMul2On2Then4() {
		Calculate calc = new Calculate();
		calc.mul(2D,2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}

	@Test
	public void whenDiv8On2Then4() {
		Calculate calc = new Calculate();
		calc.div(8D,2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}


}