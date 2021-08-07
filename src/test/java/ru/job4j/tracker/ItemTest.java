package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortIncreas() {
        List<Item> list = Arrays.asList(
                new Item("Find name3"),
                new Item("Find name2"),
                new Item("Find name1")
        );
        Collections.sort(list, new SortByNameIncreaseItem());
        assertThat(list.get(0).getName(), is("Find name1"));
    }

    @Test
    public void whenSortWaning() {
        List<Item> list = Arrays.asList(
                new Item("Find name1"),
                new Item("Find name2"),
                new Item("Find name3")
        );
        Collections.sort(list, new SortByNameWaningItem());
        assertThat(list.get(0).getName(), is("Find name3"));
    }

}