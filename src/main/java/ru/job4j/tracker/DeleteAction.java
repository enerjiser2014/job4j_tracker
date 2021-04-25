package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter task id to delete: ");
        if (!tracker.delete(id)) {
            System.out.println("Error! id can't delete");
        } else {
            System.out.println("id: " + id + " deleted");
        }
        return true;
    }
}
