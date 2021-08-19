package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(Double.NaN);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(v -> new Tuple(v.getName(),
                v.getSubjects().stream()
                    .mapToInt(Subject::getScore)
                        .average()
        .orElse(Double.NaN)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
        .collect(Collectors.groupingBy(Subject::getName, Collectors.averagingDouble(Subject::getScore)))
        .entrySet().stream()
        .map(v -> new Tuple(v.getKey(), v.getValue()))
                .sorted(Comparator.comparing(Tuple::getName).reversed())
        .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return  stream.map(v -> new Tuple(v.getName(),
                v.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore)).get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(v -> new Tuple(v.getKey(), v.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
