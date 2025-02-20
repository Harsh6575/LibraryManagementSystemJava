package Models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private List<Book> borrowedBooks;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.setBorrowed(false);
            borrowedBooks.remove(book);
        }
    }
}
