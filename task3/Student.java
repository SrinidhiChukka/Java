// Student.java
public class Student extends User {
    public Student(String userId, String name) {
        super(userId, name, 3); // borrow limit = 3
    }
}
