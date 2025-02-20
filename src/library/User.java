package library;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Library library, String bookTitle) {
        Book book = library.findBook(bookTitle);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            borrowedBooks.add(book);
        } else {
            System.out.println("Book not found or unavailable.");
        }
    }

    public void returnBook(Library library, String bookTitle) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                book.returnBook();
                borrowedBooks.remove(book);
                return;
            }
        }
        System.out.println("You haven't borrowed this book.");
    }
}
