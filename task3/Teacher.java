
// Teacher.java
public class Teacher extends User {
    public Teacher(String userId, String name) {
        super(userId, name, 5); // borrow limit = 5
    }
}
