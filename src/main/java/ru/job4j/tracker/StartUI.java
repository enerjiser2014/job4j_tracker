package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            }
            else if (select == 1) {
                for (Item item:tracker.findAll()
                     ) {
                    System.out.println(item);
                }
            }
            else if (select == 2) {
                System.out.println("Enter task id to change: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter task name to change: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (!tracker.replace(id, newItem)){
                    System.out.println("Error! id dont changed");
                }
            }
            else if (select == 3) {
                System.out.println("Enter task id to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (!tracker.delete(id)){
                    System.out.println("Error! id dont deleted");
                }
            }
            else if (select == 4) {
                System.out.println("Enter task id to find: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Error! task not found");
                }
            }
            else if (select == 5) {
                System.out.println("Enter task name to find: ");
                String taskName = scanner.nextLine();
                Item items[] = tracker.findByName(taskName);
                if (items.length > 0) {
                    for (Item item:items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Error! task not found");
                }
            }
            else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}