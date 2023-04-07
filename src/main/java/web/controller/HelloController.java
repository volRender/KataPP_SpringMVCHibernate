package web.controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CarService;
import service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	private CarServiceImpl carService;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(ModelMap model) {
		model.addAttribute("cars", carService.getCarList());
		return "cars";
	}

	@GetMapping(value = "/cars?count={count}")
	public String printCountedCars(@PathVariable("count") int count, ModelMap model) {
		model.addAttribute("countedCars", carService.getCountedCars(count));
		return "cars";
	}
}