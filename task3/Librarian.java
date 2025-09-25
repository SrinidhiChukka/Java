

// Librarian.java
public class Librarian extends User {
    public Librarian(String userId, String name) {
        super(userId, name, 10); // can borrow but also manage books
    }
}
