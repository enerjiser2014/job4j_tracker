package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
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
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        int count = 0;
        while (count < items.length) {
            items[count++] = tracker.add(new Item("test"));
        }
        Input in = new StubInput(
                new String[] {"0" , "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        int count = 0;
        while (count < items.length) {
            items[count] = tracker.add(new Item("test"+(count+1)));
            count++;
        }
        Input in = new StubInput(
                new String[] {"0" , "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        // check results
        int id = 1;
        Item check = tracker.findById(id);
        assertThat(check.getId(), is(id));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        int count = 0;
        while (count < items.length) {
            items[count] = tracker.add(new Item("test"+(count+1)));
            count++;
        }
        Input in = new StubInput(
                new String[] {"0" , "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        // check results
        Item findByName  = tracker.findByName("test1")[0];
        Item check = tracker.findById(1);
        assertThat(findByName, is(check));
    }

}