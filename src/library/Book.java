package library;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned successfully!");
    }

    @Override
    public String toString() {
        return title + " by " + author + " - " + (isAvailable ? "Available" : "Not Available");
    }
}
