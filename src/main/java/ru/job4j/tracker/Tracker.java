package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private  final ArrayList<Item> items = new ArrayList<Item>();
    //private final Item[] items = new Item[100];
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        return indexOf(id) != -1 ? items.get(indexOf(id)) : null;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemTmp = new ArrayList<Item>();
        for (Item i : items) {
            if (i.getName().equals(key)) {
                itemTmp.add(i);
            }
        }
        return itemTmp;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
            }
        }
        return rsl;
    }

    public boolean replace(int idRep, Item item) {
        if (indexOf(idRep) != -1) {
            items.set(indexOf(idRep), item);
                return true;
            }
        return false;
    }

    public boolean delete(int id) {
        if (indexOf(id) != -1) {
            items.remove(indexOf(id));
            return true;
        }
        return false;
    }

}