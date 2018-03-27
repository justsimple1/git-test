package ru.job4j;


import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConverterTest {

    @Test
    public void when240RubleToDollarThen3Point49(){
        Converter conv = new Converter();
        double result =conv.rubleToDollar(200);
        assertThat(result, is(3.49D));
    }

    @Test
    public void when300RubleToEuroThen4point21(){
        Converter conv = new Converter();
        double result =conv.rubleToEuro(300);
        assertThat(result, is(4.21D));
    }
    @Test
    public void when3EuroToRubleThen213point6(){
        Converter conv = new Converter();
        double result =conv.euroToRuble(3);
        assertThat(result, is(213.6D));
    }
    @Test
    public void when5DollarToRubleThen286(){
        Converter conv = new Converter();
        double result =conv.dollarToRuble(5);
        assertThat(result, is(286D));
    }

}
