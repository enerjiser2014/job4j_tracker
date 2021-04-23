package ru.job4j.tracker;

public class StartUI {

    public void init(ConsoleInput input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            String msg = "(Здесь может быть ваша реклама)";
            int select = Integer.parseInt(input.askStr(msg));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                for (Item item : tracker.findAll()
                ) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("Enter task id to change: ");
                int id = Integer.parseInt(input.askStr(msg));
                System.out.println("Enter task name to change: ");
                String name = input.askStr(msg);
                Item newItem = new Item(name);
                if (!tracker.replace(id, newItem)) {
                    System.out.println("Error! can't change");
                } else {
                    System.out.println("id: " + id + " changed");
                }
            } else if (select == 3) {
                System.out.println("Enter task id to delete: ");
                int id = Integer.parseInt(input.askStr(msg));
                if (!tracker.delete(id)) {
                    System.out.println("Error! id can't delete");
                } else {
                    System.out.println("id: " + id + " deleted");
                }

            } else if (select == 4) {
                System.out.println("Enter task id to find: ");
                int id = Integer.parseInt(input.askStr(msg));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Error! task not found");
                }
            } else if (select == 5) {
                System.out.println("Enter task name to find: ");
                String taskName = input.askStr(msg);
                Item items[] = tracker.findByName(taskName);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Error! task not found");
                }
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