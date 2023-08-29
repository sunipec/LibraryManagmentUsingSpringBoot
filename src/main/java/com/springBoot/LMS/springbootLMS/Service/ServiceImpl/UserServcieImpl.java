package com.springBoot.LMS.springbootLMS.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.springBoot.LMS.springbootLMS.Entity.Book;
import com.springBoot.LMS.springbootLMS.Entity.User;
import com.springBoot.LMS.springbootLMS.Payload.BookDTO;
import com.springBoot.LMS.springbootLMS.Payload.UserDTO;
import com.springBoot.LMS.springbootLMS.Repository.BookRepository;
import com.springBoot.LMS.springbootLMS.Repository.UserRepository;
import com.springBoot.LMS.springbootLMS.Service.UserService;

@Service
public class UserServcieImpl implements UserService{

	
	
	public UserRepository userRepo;
	

	public UserServcieImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	
	public User getFromDTO(UserDTO userDto) {
		// DTO converted into entity
		User user = new User();
		user.setId(userDto.getId());
		user.setPassword(userDto.getPassword());

		return user;
	}

	public UserDTO getFromEntity(User user) {
		// convert entity to DTO

		UserDTO userResponse = new UserDTO();
		userResponse.setId(user.getId());
		userResponse.setPassword(user.getPassword());

		return userResponse;
	}
	
	
	@Override
	public String userLogin(long Id, String password) {
		
		User user = userRepo.findById(Id).orElse(null);

		if (user != null) {

			String pass = user.getPassword();
			if (pass.equalsIgnoreCase(password)) {
				return "User Login Successfully";

			}

		}

		return "Login Failed";
	}


	@Override
	public UserDTO RegisterUser(UserDTO userDto) {
		
		User user=getFromDTO(userDto);
		
		User newuser = userRepo.save(user);
		
		UserDTO userDtonew = getFromEntity(newuser);
		return userDtonew;
		
	}


	
	
	
	
	
	
	
	
	
}
