import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You borrowed: " + title);
        } else {
            System.out.println("Sorry, book not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned: " + title);
    }

    public void display() {
        System.out.println(title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)"));
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) { books.add(b); }

    public void showBooks() {
        for (Book b : books) { b.display(); }
    }

    public Book findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) return b;
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Effective Java", "Joshua Bloch"));

        while (true) {
            System.out.println("\n1. Show Books\n2. Borrow Book\n3. Return Book\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String borrowTitle = sc.nextLine();
                    Book b1 = library.findBook(borrowTitle);
                    if (b1 != null) b1.borrowBook();
                    else System.out.println("Book not found.");
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    String returnTitle = sc.nextLine();
                    Book b2 = library.findBook(returnTitle);
                    if (b2 != null) b2.returnBook();
                    else System.out.println("Book not found.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
