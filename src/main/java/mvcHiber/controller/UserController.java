package mvcHiber.controller;

import mvcHiber.service.UserService;
import mvcHiber.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping(value = "/")
	public String printUsers(ModelMap model) {
		model.addAttribute("users", userService.allUsers());
		return "users";
	}
}