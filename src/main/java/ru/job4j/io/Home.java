package ru.job4j.io;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Home {
    public static boolean generateBy(String origin, String line) {
        String[] o = origin.split(" ");
        String[] l = line.split(" ");
        boolean rsl = true;
        boolean c = false;
        for (String i : l) {
            if (!rsl) {
                return false;
            }
            for (String j: o) {
                if (i.equals(j)) {
                    c = true;
                    continue;
                }
            }
            if (c) {
                rsl = true;
                c = false;
            } else {
                rsl = false;
            }
        }
        return rsl;
    }
}
