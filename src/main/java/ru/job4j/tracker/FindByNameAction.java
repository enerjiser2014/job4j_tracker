package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String taskName = input.askStr("Enter task name to find: ");
        Item items[] = tracker.findByName(taskName);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Error! task not found");
        }
        return true;
    }
}
