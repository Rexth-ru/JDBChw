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
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        Employee employee1 = new Employee(10,"Dan","Kim","man",22,7);
//        employeeDAO.create(employee1);
//        employeeDAO.update(new Employee(10, "Dan","Kim","man",33,7));
//        System.out.println(employeeDAO.getById(14));
//        List<Employee> list = employeeDAO.getAllEmployees();
//        list.stream().forEach(System.out::println);
        employeeDAO.delete(new Employee(9,"Danny","Kim","man",17,5));
    }
}
