package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter task id to delete: ");
        if (!tracker.delete(id)) {
            out.println("Error! id can't delete");
        } else {
            out.println("id: " + id + " deleted");
        }
        return true;
    }
}
