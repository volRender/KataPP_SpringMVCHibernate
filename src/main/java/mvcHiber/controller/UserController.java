package mvcHiber.controller;

import mvcHiber.model.User;
import mvcHiber.service.UserService;
import mvcHiber.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping( "/")
	public String printUsers(Model model) {
		model.addAttribute("users", userService.allUsers());
		return "users";
	}

	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("newUser", new User());
		return "newUser";
	}

	@PostMapping()
	public String saveUser(@ModelAttribute("new1") User user) {
		userService.addUser(user);
		return "redirect:/";
	}
}