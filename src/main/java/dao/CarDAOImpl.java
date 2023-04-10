package dao;

import model.Car;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<Car> getCountedCars(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
