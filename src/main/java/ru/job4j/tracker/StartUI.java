package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        Output out = new ConsoleOutput();
        out.println("Menu. ");
        for (int index = 0; index < actions.length; index++) {
            out.println(index  + ". " + actions[index].name());
        }
    }


    public static void main(String[] args) {
        ConsoleOutput out = new ConsoleOutput();
        ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindAllAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new ExitAction(),

        };
        new StartUI().init(input, tracker, actions);
    }
}