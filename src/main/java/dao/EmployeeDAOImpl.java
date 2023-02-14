package dao;
import config.HibernateSessionFactory;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
//Creating (adding) an Employee entity to the table
    @Override
    public void create(Employee employee) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){

            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }
//Getting a specific Employee object by id
    @Override
    public Employee getById(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        }
    }
//Getting a list of all Employee objects from the database
    @Override
    public List<Employee> getAllEmployees() {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            return session.createQuery("from Employee").list();
        }
    }
//Changing a specific Employee object in the database by id
    @Override
    public void update(Employee employee) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }
// Deleting a specific Employee object from the database by id
    @Override
    public void delete(Employee employee) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
