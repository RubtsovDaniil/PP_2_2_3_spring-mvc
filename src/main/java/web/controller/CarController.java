package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;

@Controller

public class CarController {

    private final CarDaoImpl carDaoimpl;

    @Autowired
    public CarController(CarDaoImpl carDaoimpl) {
        this.carDaoimpl = carDaoimpl;
    }


    @GetMapping("/cars")
    public String show(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null || count >= 5) {
            model.addAttribute("cars", carDaoimpl.index());
            return "cars";
        } else {
            model.addAttribute("cars", carDaoimpl.show(count));
            return "show";
        }
    }

}
