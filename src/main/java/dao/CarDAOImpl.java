package dao;

import model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {
    private List<Car> carList;
    {
        carList = new ArrayList<>();
        carList.add(new Car("Car1", 1, "Danya"));
        carList.add(new Car("Car2", 2, "Misha"));
        carList.add(new Car("Car3", 3, "Nikita"));
        carList.add(new Car("Car4", 4, "Vlad"));
        carList.add(new Car("Car5", 5, "Andrey"));
    }
    @Override
    public List<Car> getCars(int count) {
        List<Car> carCountedList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carCountedList.add(carList.get(i));
        }
        return carCountedList;
    }
}
