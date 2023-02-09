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

        City city1 = new City("Gdov");
        cityDAO.create(city1);
        Employee employee2 = new Employee("Zak","Worner","man",27);
        employee2.setCity(city1);
        employeeDAO.create(employee2);




    }
}
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        Employee employee1 = new Employee(10,"Dan","Kim","man",22,7);
//        employeeDAO.create(employee1);
//        employeeDAO.update(new Employee(10, "Dan","Kim","man",33,7));
//        System.out.println(employeeDAO.getById(14));
//        List<Employee> list = employeeDAO.getAllEmployees();
//        list.stream().forEach(System.out::println);
//        employeeDAO.delete(new Employee(9,"Danny","Kim","man",17,5));

//    }
//}





//        final String user = "postgres";
//        final String password = "469841";
//        final String url = "jdbc:postgresql://localhost:5432/skypro";
//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
//            List<Employee> employeeList = employeeDAO.getAllEmployees();
//            for (Employee em : employeeList) {
//                System.out.println(em);
//            }
//            employeeDAO.deleteById(2);
//            employeeDAO.updateById(5, 25);
//
//            Employee employee = new Employee(14, "Tom", "Kolins", "man", 44, new City(4));
//            employeeDAO.create(employee);
//            System.out.println(employeeDAO.getById(7));
//        }
//    }
//}
//
