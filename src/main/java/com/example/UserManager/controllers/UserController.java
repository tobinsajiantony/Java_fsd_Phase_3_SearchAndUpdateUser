package com.example.UserManager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(UserController.class);


	@GetMapping("/users")
	public String showUsers(ModelMap model) {


		logger.info("Getting all Users");
		Iterable<User> users = userService.GetAllUsers();

		logger.info("Passing users to view");
		model.addAttribute("users", users);    

		return "users";
	}

	@GetMapping("/EditUser")
	public String getUserById(ModelMap model,@RequestParam("userId") int Id) {

		System.out.println("Controller hit");
		System.out.println(Id);
		User user = userService.GetUserById(Id);
		if(user!=null) {
			model.addAttribute("user", user);
			return "EditUser";
		}
		else {
			model.addAttribute("message", "No User with the ID found");
			return "Error";
		}
	}
	
	@RequestMapping(value = "/updateUser")
	public String UpdateUser(ModelMap model, @RequestParam("id") int Id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("update hit");
		System.out.println(Id);
		if(name!="" && email!="" && password!="") {
			User user = new User(Id, name, email, password);
			userService.UpdateUser(user);
			model.addAttribute("message", "User Updated Succesfully");
			return "success";
		}
		else if(name == "") {
			model.addAttribute("message", "Please Enter Name");
			return "Error";
		}
		else if(email == "") {
			model.addAttribute("message", "Please Enter Email");
			return "Error";
		}
		else {
			model.addAttribute("message", "Please Enter Password");
			return "Error";
		}
	}


}
