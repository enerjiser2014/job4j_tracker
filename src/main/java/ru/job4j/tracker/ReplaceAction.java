package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter task id to change: ");
        String name = input.askStr("Enter task name to change: ");
        Item newItem = new Item(name);
        if (!tracker.replace(id, newItem)) {
            out.println("Error! can't change");
        } else {
            out.println("id: " + id + " changed");
        }
        return true;
    }
}
