package ru.job4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(
                -5, 4, 3, -12, 21, 38, -100));
        List<Integer> sort = list.stream().filter(i -> i > 0)
                .collect(Collectors.toList());
        sort.forEach(System.out::println);
    }
}
