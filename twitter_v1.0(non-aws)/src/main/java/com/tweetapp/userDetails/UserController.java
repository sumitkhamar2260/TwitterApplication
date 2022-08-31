package com.tweetapp.userDetails;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/tweets/register")
	public String register(@RequestBody Users user) {
		
		String createdUser = userService.register(user);
//		logger.info(createdUser.toString() + new Date());
		return createdUser;
		
	}
	
	@GetMapping("/tweets/login/{uname}/{password}")
	public String authencticate(@PathVariable String uname,@PathVariable String password) {
		return userService.authenticate(uname, password);
	}
	
	@PutMapping("/tweets/{uname}/forgot")
	public String updatePassword(@PathVariable String uname, @RequestBody Users user){
		String user1 = userService.updatePassword(uname, user);
		logger.info(user1);
		return user1;
	}
	
	@GetMapping("/tweets/users/all")
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/tweets/user/search/{str}")
	public List<Users> searchByRegex(@PathVariable String str){
		return userService.searchByRegex(str);
	}
	
	@GetMapping("/tweets/user/{uname}")
	public Users getUser(@PathVariable String uname){
		return userService.getUser(uname);
	}
	
	

}
