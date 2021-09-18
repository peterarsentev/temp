package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    public List<Integer> matrToList(Integer[][] mat) {
        return Stream.of(mat).flatMap(Stream::of).collect(Collectors.toList());
    }
}
