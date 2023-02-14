package dao;

import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }
// Creating (adding) an Employee entity to a table
    @Override
    public void create(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into employee (id, first_name, last_name, gender, age, city_id) values (?,?,?,?,?,?)")) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getCity().getCityId());
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//Getting a specific Employee object by id
    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try (PreparedStatement statement = connection.prepareStatement("select*from employee inner join city on employee.city_id=city.city_id and employee.id=?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
//Getting a list of all Employee objects from the database
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select*from employee inner join city on employee.city_id=city.city_id ")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name"));
                employees.add(new Employee(id,firstName,lastName,gender,age,city));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
//Changing a specific Employee object in the database by id
    @Override
    public void updateById(int id, int age) {
        try (PreparedStatement statement = connection.prepareStatement("update employee set age = ? where id =?")) {
            statement.setInt(1,age);
            statement.setInt(2,id);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
//Deleting a specific Employee object from the database by id
    @Override
    public void deleteById(int id) {
        try (PreparedStatement statement = connection.prepareStatement("delete from employee where employee.id=?")) {
            statement.setInt(1,id);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
