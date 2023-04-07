package service;

import dao.CarDAOImpl;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDAOImpl carDAO;

    @Override
    public List<Car> getCars(int count) {
        return carDAO.getCars(count);
    }
}
