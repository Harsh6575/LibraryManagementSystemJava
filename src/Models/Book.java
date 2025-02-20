package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private final StringProperty title;
    private final StringProperty author;
    private final StringProperty isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.isbn = new SimpleStringProperty(isbn);
        this.isBorrowed = false;
    }

    public StringProperty titleProperty() { return title; }
    public StringProperty authorProperty() { return author; }
    public StringProperty isbnProperty() { return isbn; }
    public StringProperty statusProperty() { return new SimpleStringProperty(isBorrowed ? "Borrowed" : "Available"); }

    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { this.isBorrowed = borrowed; }

    public String getTitle() { return title.get(); }
    public String getAuthor() { return author.get(); }
}
