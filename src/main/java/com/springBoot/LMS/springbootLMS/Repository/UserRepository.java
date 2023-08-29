package com.springBoot.LMS.springbootLMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springBoot.LMS.springbootLMS.Entity.User;

public interface UserRepository extends JpaRepository<User , Long>{

	
	

}
