// Library.java (Singleton)
import java.util.*;

public class Library {
    private static Library instance;
    private Map<String, Book> books = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) instance = new Library();
        return instance;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void registerUser(User user) {
        users.put(user.getUserId(), user);
    }

    public Book searchBookByTitle(String title) {
        return books.values().stream()
            .filter(b -> b.getTitle().equalsIgnoreCase(title))
            .findFirst().orElse(null);
    }

    public void issueBook(String userId, String isbn) throws Exception {
        User user = users.get(userId);
        Book book = books.get(isbn);
        if (user == null || book == null) throw new Exception("User or Book not found!");
        user.borrowBook(book);
        System.out.println("Book issued successfully to " + user.getName());
    }

    public void returnBook(String userId, String isbn) throws Exception {
        User user = users.get(userId);
        Book book = books.get(isbn);
        if (user == null || book == null) throw new Exception("User or Book not found!");
        user.returnBook(book);
        System.out.println("Book returned successfully by " + user.getName());
    }
}
