package com.springBoot.LMS.springbootLMS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springBoot.LMS.springbootLMS.Service.adminService;

@RestController
@RequestMapping("/api/admin")
public class adminLoginController {

	private adminService  adminservice;
	
	public adminLoginController(adminService adminservice) {
		this.adminservice=adminservice;
	}
	
	
	@GetMapping("/login/{Id}/{password}")
	public String getAdminLogin(@PathVariable("Id") long Id,@PathVariable("password") String password){
		return adminservice.adminlogin(Id,password);
	}
	
}
