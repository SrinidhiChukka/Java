import java.sql.*;

public class EmployeeDAO {
    Connection con = DBConnection.getConnection();

    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (name, department, designation, salary, joining_date, performance_score) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, emp.getName());
        ps.setString(2, emp.getDepartment());
        ps.setString(3, emp.getDesignation());
        ps.setDouble(4, emp.getSalary());
        ps.setDate(5, Date.valueOf(emp.getJoiningDate()));
        ps.setInt(6, emp.getPerformanceScore());
        ps.executeUpdate();
    }

    public void viewEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        ResultSet rs = con.createStatement().executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getInt("emp_id") + " | " + rs.getString("name") + " | " + rs.getString("department") + " | " + rs.getDouble("salary"));
        }
    }

    // Update, Delete, Search methods can follow the same pattern
}
