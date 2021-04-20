package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            if (matches > 3 || matches < 1) {
                System.out.println("Ошибка! Вы должны были ввести число от 1 до 3, ход переходит следующему игроку.");
                continue;
            }

            if (matches == 1) {
                count -= 1;
            }
            else if (matches == 2) {
                count -= 2;
            }
            else if (matches == 3) {
                count -= 3;
            }
            System.out.println("Осталось " + count + " спичек, следующий ход:");
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}