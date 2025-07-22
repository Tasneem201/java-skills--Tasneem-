// Base class
class Book {
    // Protected variables
    protected String title;
    protected String author;
    protected int pages;
    protected boolean isAvailable;

    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true; // by default available
    }

    // Basic methods
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + isAvailable);
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public boolean isAvailable() { return isAvailable; }
}

// Child class
class Textbook extends Book {
    private String subject;
    private int edition;

    // Constructor
    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title, author, pages);
        this.subject = subject;
        this.edition = edition;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }

    // Getters
    public String getSubject() { return subject; }
    public int getEdition() { return edition; }
}

// Main class to test
public class Library {
    public static void main(String[] args) {
        // Create 2 regular books
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 208);
        Book book2 = new Book("1984", "George Orwell", 328);

        // Create 1 textbook
        Textbook textbook = new Textbook("Java Programming", "John Doe", 550, "Computer Science", 3);

        // Test borrowing and returning
        book1.borrowBook();
        book1.returnBook();
        book2.borrowBook();

        // Display all book info
        System.out.println("\nBook 1 Info:");
        book1.displayInfo();
        System.out.println("\nBook 2 Info:");
        book2.displayInfo();
        System.out.println("\nTextbook Info:");
        textbook.displayInfo();
    }
}
