package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {
   // List<Car> getCars();

   // Car showCar(String modelCar);

    List<Car> getListCar();

    List<Car> getCarsId(int id);
}
