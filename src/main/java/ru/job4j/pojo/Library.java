package ru.job4j.pojo;

public class Library {

    private static void print(Book[] books, String message) {
        System.out.println("\t" + message);
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages());
        }
    }

    private static void swap(Book[] books, int first, int second) {
        Book temp = books[first];
        books[first] = books[second];
        books[second] = temp;
    }

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Колобок", 25);
        books[1] = new Book("Мойдодыр", 50);
        books[2] = new Book("Незнайка на Луне", 220);
        books[3] = new Book("Clean code", 400);
        print(books, "Список книг:");

        swap(books, 0, 3);
        print(books, "Список книг после перестановки:");

        System.out.println("\tСписок книг с фильтром:");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}
