import dao.CityDAO;
import dao.CityDAOImpl;
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
        CityDAO cityDAO = new CityDAOImpl();
//implementation of some crud operations
        City city1 = new City("Gdov");
        cityDAO.create(city1);
        Employee employee2 = new Employee("Zak","Worner","man",27);
        employee2.setCity(city1);
        employeeDAO.create(employee2);

    }
}
