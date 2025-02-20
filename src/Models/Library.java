package Models;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }
    public List<Book> getBooks() { return books; }
    public List<User> getUsers() { return users; }

    public User findUser(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }

    public Book findBook(String title) {
        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }
}