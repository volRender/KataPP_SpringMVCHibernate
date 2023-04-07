package dao;

import model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> getCars(int count);
}
