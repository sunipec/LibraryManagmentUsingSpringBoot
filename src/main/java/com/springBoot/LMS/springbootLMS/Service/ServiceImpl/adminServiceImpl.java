package com.springBoot.LMS.springbootLMS.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springBoot.LMS.springbootLMS.Entity.Admin;
import com.springBoot.LMS.springbootLMS.Payload.adminDTO;
import com.springBoot.LMS.springbootLMS.Repository.adminRepository;
import com.springBoot.LMS.springbootLMS.Service.adminService;

@Service
public class adminServiceImpl implements adminService {

	public adminRepository adminRepo;

	public adminServiceImpl(adminRepository adminRepo) {
		this.adminRepo = adminRepo;
	}

	public Admin getFromDTO(adminDTO adminDto) {
		// DTO converted into entity
		Admin admin = new Admin();
		admin.setId(adminDto.getId());
		admin.setPassword(adminDto.getPassword());

		return admin;
	}

	public adminDTO getFromEntity(Admin admin) {
		// convert entity to DTO

		adminDTO adminResponse = new adminDTO();
		adminResponse.setId(admin.getId());
		adminResponse.setPassword(admin.getPassword());

		return adminResponse;
	}

	@Override
	public String adminlogin(Long Id, String password) {

		Admin admin = adminRepo.findById(Id).orElse(null);

		if (admin != null) {

			String pass = admin.getPassword();
			if (pass.equalsIgnoreCase(password)) {
				return "Admin Login Successfully";

			}

		}

		return "Login Failed";

	}

}
