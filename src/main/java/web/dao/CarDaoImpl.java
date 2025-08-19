package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", 1, "Black"));
        cars.add(new Car("BMW", 5, "Blue"));
        cars.add(new Car("Tesla", 3, "Yellow"));
        cars.add(new Car("VW", 5, "Black"));
        cars.add(new Car("Nissan", 10, "Grey"));
    }

    public List<Car> index() {
        return cars;
    }

    public List<Car> show(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }

}
