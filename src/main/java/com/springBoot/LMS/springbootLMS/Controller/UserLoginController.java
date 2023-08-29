package com.springBoot.LMS.springbootLMS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LMS.springbootLMS.Payload.BookDTO;
import com.springBoot.LMS.springbootLMS.Payload.UserDTO;
import com.springBoot.LMS.springbootLMS.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserLoginController {

	private UserService userService;
	
	public UserLoginController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/login/{Id}/{password}")
	public String getAdminLogin(@PathVariable("Id") long Id,@PathVariable("password") String password){
		return  userService.userLogin(Id,password);
	}		
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> RegisterUser(@RequestBody UserDTO userDto){
		return  new ResponseEntity<>(userService.RegisterUser(userDto),HttpStatus.CREATED);
	}
	
	
	
}
