package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionDiTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDi.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqrFunctionThenResults() {
        List<Double> result = FunctionDi.diapason(1, 4, x -> x * x + x + 3);
        List<Double> expected = Arrays.asList(5D, 9D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExpFunctionThenResults() {
        List<Double> result = FunctionDi.diapason(3, 6, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(8D, 16D, 32D);
        assertThat(result, is(expected));
    }

}