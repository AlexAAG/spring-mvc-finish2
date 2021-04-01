package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component                                              //создаем бин дао
public class CarDaoImpl implements CarDao {
    private List<Car> listCar;

    {
        listCar = new ArrayList<>();
        listCar.add(new Car("AUDI", 7, 3150000, "Business"));
        listCar.add(new Car("BMW", 5, 3410000, "Business"));
        listCar.add(new Car("Mercedes", 1, 3750000, "Business"));
    }

                                                        //возвращает спиоск машин
    @Override
    public List<Car> getCars() {
        return listCar;
    }

                                                        //возвращает одну модель
    @Override
    public Car showCar(String modelCar) {
                                            //создаем стрим, фильтруем по моделям, ищем машину или возвращаем нал

        return listCar.stream().filter(listCar -> listCar.getModelCar() == modelCar).findAny().orElse(null);
    }
}
