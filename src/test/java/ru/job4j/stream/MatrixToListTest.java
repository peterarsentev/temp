package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenMatrToList() {
        Integer[][] matr = {
                {1, 3},
                {4, 2}
        };
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> numbers = matrixToList.matrToList(matr);
        List<Integer> exp = Arrays.asList(1, 3, 4, 2);
        assertThat(numbers, is(exp));
    }

}