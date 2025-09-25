// Book.java
public class Book {
    private final String isbn;
    private String title;
    private String author;
    private int copiesAvailable;

    public Book(String isbn, String title, String author, int copiesAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getCopiesAvailable() { return copiesAvailable; }

    public void borrowBook() throws Exception {
        if (copiesAvailable <= 0) throw new Exception("Book not available!");
        copiesAvailable--;
    }

    public void returnBook() {
        copiesAvailable++;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s by %s (Available: %d)", isbn, title, author, copiesAvailable);
    }
}
