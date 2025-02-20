package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Models.Book;

public class MainController {
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField isbnField;
    @FXML private TableView<Book> bookTable;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> isbnColumn;
    @FXML private TableColumn<Book, String> statusColumn;
    @FXML private Label statusLabel;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns to Book properties
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        isbnColumn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        bookTable.setItems(bookList);
    }

    public void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();

        if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty()) {
            Book newBook = new Book(title, author, isbn);
            bookList.add(newBook);

            // Clear input fields after adding
            titleField.clear();
            authorField.clear();
            isbnField.clear();
        }
    }

    public void borrowBook() {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            if (!selectedBook.isBorrowed()) {
                selectedBook.setBorrowed(true);
                bookTable.refresh(); // Update TableView
                statusLabel.setText("Book borrowed: " + selectedBook.getTitle());
            } else {
                statusLabel.setText("Book is already borrowed.");
            }
        } else {
            statusLabel.setText("Select a book to borrow.");
        }
    }

    public void returnBook() {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            if (selectedBook.isBorrowed()) {
                selectedBook.setBorrowed(false);
                bookTable.refresh(); // Update TableView
                statusLabel.setText("Book returned: " + selectedBook.getTitle());
            } else {
                statusLabel.setText("Book is not borrowed.");
            }
        } else {
            statusLabel.setText("Select a book to return.");
        }
    }
}
