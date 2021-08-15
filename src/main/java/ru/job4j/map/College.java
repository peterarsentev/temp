package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst();
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> student = findByAccount(account);
        if (student.isPresent()) {
            Optional<Subject> rsl = students.get(student.get())
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst();
            return rsl;
            }
        return Optional.empty();
    }
}
