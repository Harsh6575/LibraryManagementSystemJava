package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        User user = new User("John Doe");

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter the book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    user.borrowBook(library, borrowTitle);
                    break;

                case 4:
                    System.out.print("Enter the book title to return: ");
                    String returnTitle = scanner.nextLine();
                    user.returnBook(library, returnTitle);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
