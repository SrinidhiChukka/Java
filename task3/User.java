// User.java
import java.util.*;

public abstract class User {
    protected String userId;
    protected String name;
    protected int borrowLimit;
    protected List<Book> borrowedBooks = new ArrayList<>();

    public User(String userId, String name, int borrowLimit) {
        this.userId = userId;
        this.name = name;
        this.borrowLimit = borrowLimit;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }

    public void borrowBook(Book book) throws Exception {
        if (borrowedBooks.size() >= borrowLimit)
            throw new Exception("Borrowing limit reached!");
        book.borrowBook();
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
        }
    }

    public void listBorrowedBooks() {
        borrowedBooks.forEach(System.out::println);
    }
}

