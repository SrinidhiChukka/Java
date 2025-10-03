import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        try {
            while(true){
                System.out.println("1. Add Employee\n2. View Employees\n3. Update\n4. Delete\n5. Exit");
                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.print("Enter employee name: ");
                        sc.nextLine(); // consume newline
                        String name = sc.nextLine();
                        
                        System.out.print("Enter department: ");
                        String department = sc.nextLine();
                        
                        System.out.print("Enter designation: ");
                        String designation = sc.nextLine();
                        
                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();
                        
                        System.out.print("Enter joining date (YYYY-MM-DD): ");
                        String dateStr = sc.next();
                        LocalDate joiningDate = LocalDate.parse(dateStr);
                        
                        System.out.print("Enter performance score: ");
                        int performanceScore = sc.nextInt();
                        
                        Employee emp = new Employee(name, department, designation, salary, joiningDate, performanceScore);
                        dao.addEmployee(emp);
                        System.out.println("Employee added successfully!");
                        break;
                    case 2:
                        dao.viewEmployees();
                        break;
                    case 5:
                        System.exit(0);
                }
            }
        } finally {
            sc.close();
        }
    }
}
