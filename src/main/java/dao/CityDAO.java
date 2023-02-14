package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDAO {
    void create(City city);
    City getById(int id);
    List<City> getAllCity();
    void update(City city);
    void delete(City city);
}