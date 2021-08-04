package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

        @Test
    public void whenCreateItem() {
            Output output = new ConsoleOutput();
            Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
            ArrayList<UserAction> actions = new ArrayList<UserAction>();
            actions.add(new CreateAction(output));
            actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        /* Добавим в tracker новую заявку */
        Item item1 = tracker.add(new Item("First item"));
        Item item2 = tracker.add(new Item("Second item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item2.getId()), "New item name", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new EditAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item2.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindAllItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        String ln = System.lineSeparator();
        Item item = tracker.add(new Item("FindAll item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindAllAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + ln + "0. Show all items" + ln + "1. Exit program."
                + ln + "=== Show all items ====" + ln + item + ln + "Menu."
                + ln + "0. Show all items" + ln + "1. Exit program." + ln));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        String ln = System.lineSeparator();
        Item item1 = tracker.add(new Item("Find name1"));
        Item item2 = tracker.add(new Item("Find name2"));
        Input in = new StubInput(
                new String[] {"0", "Find name2", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + ln + "0. Find items by name" + ln + "1. Exit program."
                + ln + "=== Find items by name ====" + ln + item2 + ln + "Menu."
                + ln + "0. Find items by name" + ln + "1. Exit program." + ln));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        String ln = System.lineSeparator();
        Item item1 = tracker.add(new Item("Find name1"));
        Item item2 = tracker.add(new Item("Find name2"));
        int i = item1.getId();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(i), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + ln + "0. Find item by id" + ln + "1. Exit program."
                + ln + "=== Find item by id ====" + ln + item1 + ln + "Menu."
                + ln + "0. Find item by id" + ln + "1. Exit program." + ln));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"12", "0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit program." + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit program." + ln
                )
        );
    }

}