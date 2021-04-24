package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String msg = "Enter name: ";
        String name = input.askStr(msg);
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAll(Tracker tracker) {
        for (Item item : tracker.findAll()
        ) {
            System.out.println(item);
        }
    }

    public static void replaceItem(ConsoleInput input, Tracker tracker) {
        int id = input.askInt("Enter task id to change: ");
        String name = input.askStr("Enter task name to change: ");
        Item newItem = new Item(name);
        if (!tracker.replace(id, newItem)) {
            System.out.println("Error! can't change");
        } else {
            System.out.println("id: " + id + " changed");
        }
    }

    public static void FindItemById(ConsoleInput input, Tracker tracker) {
        int id = input.askInt("Enter task id to find: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Error! task not found");
        }
    }

    public static void deleteItem(ConsoleInput input, Tracker tracker) {
        int id = input.askInt("Enter task id to delete: ");
        if (!tracker.delete(id)) {
            System.out.println("Error! id can't delete");
        } else {
            System.out.println("id: " + id + " deleted");
        }
    }

    public static void findItemByName(ConsoleInput input, Tracker tracker) {
        String taskName = input.askStr("Enter task name to find: ");
        Item items[] = tracker.findByName(taskName);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Error! task not found");
        }
    }

    public void init(ConsoleInput input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAll(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.FindItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("0. Add new Item" + System.lineSeparator() +
                "1. Show all items" + System.lineSeparator() +
                "2. Edit item" + System.lineSeparator() +
                "3. Delete item" + System.lineSeparator() +
                "4. Find item by Id" + System.lineSeparator() +
                "5. Find items by name" + System.lineSeparator() +
                "6. Exit Program");
    }


    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}