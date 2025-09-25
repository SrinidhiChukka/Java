import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        Scanner sc = new Scanner(System.in);

        // Sample data
        library.addBook(new Book("101", "Java Basics", "James Gosling", 2));
        library.addBook(new Book("102", "OOP Principles", "Grady Booch", 1));
        library.registerUser(new Student("S1", "Alice"));
        library.registerUser(new Teacher("T1", "Dr. Bob"));

        boolean running = true;

        while (running) {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter copies: ");
                        int copies = sc.nextInt();
                        library.addBook(new Book(isbn, title, author, copies));
                        System.out.println("Book added!");
                    }
                    case 2 -> {
                        System.out.print("Enter user type (student/teacher): ");
                        String type = sc.nextLine().toLowerCase();
                        System.out.print("Enter userId: ");
                        String userId = sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        if (type.equals("student")) {
                            library.registerUser(new Student(userId, name));
                        } else if (type.equals("teacher")) {
                            library.registerUser(new Teacher(userId, name));
                        } else {
                            System.out.println("Invalid type!");
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        Book book = library.searchBookByTitle(title);
                        if (book != null) System.out.println(book);
                        else System.out.println("Book not found!");
                    }
                    case 4 -> {
                        System.out.print("Enter userId: ");
                        String userId = sc.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = sc.nextLine();
                        library.issueBook(userId, isbn);
                    }
                    case 5 -> {
                        System.out.print("Enter userId: ");
                        String userId = sc.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = sc.nextLine();
                        library.returnBook(userId, isbn);
                    }
                    case 6 -> {
                        running = false;
                        System.out.println("Exiting system...");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}

