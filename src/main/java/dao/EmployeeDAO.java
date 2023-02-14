package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee getById(int id);
    List<Employee> getAllEmployees();
    void update(Employee employee);
    void delete(Employee employee);
}
