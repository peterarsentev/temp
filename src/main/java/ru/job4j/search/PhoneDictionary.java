package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> adress = s -> s.getAddress().contains(key);
        Predicate<Person> name = s -> s.getName().contains(key);
        Predicate<Person> surName = s -> s.getSurname().contains(key);
        Predicate<Person> phone = s -> s.getPhone().contains(key);
        Predicate<Person> predicate = adress.or(name).or(surName).or(phone);
        ArrayList<Person> result = new ArrayList<>();
        for (var p : persons) {
            if (predicate.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
