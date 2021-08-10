package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + right + " : " + left);
            return right.compareTo(left);
        };
        List<String> list = new ArrayList<>(Arrays.asList(
                "Ask",
                "Funny",
                "Wall"));
        list.sort(comparator);
        System.out.println(list);
    }
}
