import java.time.LocalDate;

public class Employee {
    private String name, department, designation;
    private double salary;
    private LocalDate joiningDate;
    private int performanceScore;

    // Constructor
    public Employee(String name, String department, String designation, double salary, LocalDate joiningDate, int performanceScore) {
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.performanceScore = performanceScore;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }
}
