package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.CarDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired                          //импортируем поле, чтобы внедрить в контроллер
    private CarDao carDao;

    @GetMapping(value = "/cars")
    public String getCars(Integer count, ModelMap model) {  //count передается в поисковой строке браузера?

        if(count == null) {
            List<Car> carList2 = carDao.getListCar();
            model.addAttribute("sudaIdi", carList2);
        } else {
            List<Car> carList = carDao.getCarsId(count);
            model.addAttribute("sudaIdi", carList);
        }

       //model.addAttribute("sudaIdi", carList); //sudaIdi-параметр, к которому обра-
        //щаемся в html. Параметр - carDao.getCars(), результат работы метода
//        Car car = carDao.showCar(modelCar);
//        model.addAttribute("car", car);  //называться одинаково, но это не точно. Вкладывать модель, а не представление
        return "cars";                                  //урл по которому будет показываться и лежать html
    }









//    @GetMapping("/{modelCar}")                                //передается число, которое передается в адрес метода
//    public String show(@PathVariable("modelCar") String modelCar, Model model) {
//        //получаем одну машину по id из dao и передадим на отображение и представление
//        Car car = carDao.showCar(modelCar);
//        model.addAttribute("car", car);  //называться одинаково, но это не точно. Вкладывать модель, а не представление
//        return "show";
//    }
}