package com.springBoot.LMS.springbootLMS.Service;

import com.springBoot.LMS.springbootLMS.Payload.UserDTO;

public interface UserService {
	
	String userLogin(long Id, String password);
	
	UserDTO RegisterUser(UserDTO userDto);
	
	
}
