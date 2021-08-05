package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleTracker {

    private Tracker tracker = null;

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int idRep, Item item) {
        return tracker.replace(idRep, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
