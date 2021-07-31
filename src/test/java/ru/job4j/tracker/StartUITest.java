package ru.job4j.tracker;

import org.junit.Test;

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
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindAllItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("FindAll item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction()
        };
        new StartUI(new ConsoleOutput()).init(in, tracker, actions);
        assertThat(output.toString(), is("=== Show all items ====\\r\\n" + item + "\\r\\n"));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item1 = tracker.add(new Item("Find name1"));
        Item item2 = tracker.add(new Item("Find name2"));
        Input in = new StubInput(
                new String[] {"0", "Find name2", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertTrue(output.toString().contains(item2.toString()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item1 = tracker.add(new Item("Find name1"));
        Item item2 = tracker.add(new Item("Find name2"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertTrue(output.toString().contains(item1.toString()));
    }

}