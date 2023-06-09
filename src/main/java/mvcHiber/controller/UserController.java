package mvcHiber.controller;

import mvcHiber.model.User;
import mvcHiber.service.UserService;
import mvcHiber.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String printUsers(Model model) {
		model.addAttribute("users", userService.allUsers());
		return "users";
	}

	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("newUser", new User());
		return "newUser";
	}

	@PostMapping
	public String saveUser(@ModelAttribute("newUser") User user) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/{id}/edit")
	public String getUser(@PathVariable("id") long id, Model model) {
		model.addAttribute("editedUser", userService.getUser(id));
		return "editUser";
	}

	@PatchMapping("/{id}")
	public String editUser(@ModelAttribute("editedUser") User user, @PathVariable("id") long id) {
		userService.updateUser(user, id);
		return "redirect:/users";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}