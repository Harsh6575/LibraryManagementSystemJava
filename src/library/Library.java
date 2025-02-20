package library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
