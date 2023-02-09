package dao;

import config.HibernateSessionFactory;
import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void create(City city) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){

            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }

    }

    @Override
    public City getById(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> getAllCity() {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            return session.createQuery("from City").list();
        }
    }

    @Override
    public void update(City city) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }

    }

    @Override
    public void delete(City city) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }

    }
}
