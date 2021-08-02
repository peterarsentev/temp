package ru.job4j.tracker;

import java.util.Arrays;

public class SingleTracker {

    private static SingleTracker instance;

    private Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }
    
    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int idRep, Item item) {
        return tracker.replace(idRep, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
