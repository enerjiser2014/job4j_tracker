package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        String itemId = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[] {"0", itemId, replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String itemId = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[] {"0" , itemId , "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        items[0] = tracker.add(new Item("test1"));
        items[1] = tracker.add(new Item("test2"));
        items[2] = tracker.add(new Item("test3"));

        Input in = new StubInput(
                new String[] {"0" , "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        //Item[] check = tracker.findAll();

        assertThat(out.toString(), is(
                "Menu. " + ln +
                        "0. Show all items" + ln +
                        "1. Exit program" + ln +
                        items[0].toString() + ln +
                        items[1].toString() + ln +
                        items[2].toString() + ln +
                        "Menu. " + ln +
                        "0. Show all items" + ln +
                        "1. Exit program" + ln
                )
        );
    }

    @Test
    public void whenFindByIdAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = new Item[4];
        items[1] = tracker.add(new Item("test1"));
        items[2] = tracker.add(new Item("test2"));
        items[3] = tracker.add(new Item("test3"));
        int id = 1;
        Input in = new StubInput(
                new String[] {"0" , String.valueOf(id), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        // check results

        assertThat(out.toString(), is(
                "Menu. " + ln +
                        "0. Find item by Id" + ln +
                        "1. Exit program" + ln +
                        items[id].toString() + ln +
                        "Menu. " + ln +
                        "0. Find item by Id" + ln +
                        "1. Exit program" + ln
                )
        );
    }

    @Test
    public void whenFindByNameAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = new Item[4];
        items[1] = tracker.add(new Item("test1"));
        items[2] = tracker.add(new Item("test2"));
        items[3] = tracker.add(new Item("test3"));
        int index = 1;
        String searchString = tracker.findById(index).getName();
        Input in = new StubInput(
                new String[] {"0" , searchString, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        // check results
        Item check = tracker.findById(index);
        assertThat(out.toString(), is(
                "Menu. " + ln +
                        "0. Find items by name" + ln +
                        "1. Exit program" + ln +
                        items[index].toString() + ln +
                        "Menu. " + ln +
                        "0. Find items by name" + ln +
                        "1. Exit program" + ln
                )
        );
    }

}