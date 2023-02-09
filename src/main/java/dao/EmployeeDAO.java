package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee getById(int id);
    List<Employee> getAllEmployees();
    void updateById(int id, int age);
    void deleteById(int id);

}

