package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Donald knut1",300);
        books[1] = new Book("Donald knut2",330);
        books[2] = new Book("Donald knut3", 200);
        books[3] = new Book("Clean code", 700);
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPageCount() + " pages" );
        }
        System.out.println("contain Clean code:");
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            if (b.getName().equals("Clean code")) {
                System.out.println(b.getName() + " - " + b.getPageCount() + " pages");
            }
        }

    }
}
