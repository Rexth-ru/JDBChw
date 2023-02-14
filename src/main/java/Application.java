import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "469841";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            List<Employee> employeeList = employeeDAO.getAllEmployees();
            for (Employee em : employeeList) {
                System.out.println(em);
            }
            employeeDAO.deleteById(2);
            employeeDAO.updateById(5, 25);

            Employee employee = new Employee(14, "Tom", "Kolins", "man", 44, new City(4));
            employeeDAO.create(employee);
            System.out.println(employeeDAO.getById(7));
        }
    }
}
