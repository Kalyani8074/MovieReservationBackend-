package com.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.Admin;
import com.movie.excpetion.AdminIdExistException;
import com.movie.excpetion.AdminNotFoundException;
import com.movie.iservices.IAdminService;
import com.movie.repositories.AdminRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminIdExistException {

		if (adminRepository.existsById(admin.getAdminId())) {
			throw new AdminIdExistException("The admin id already exist");
		}

		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(long adminId, Admin admin) throws AdminNotFoundException {

		Admin existAdmin = adminRepository.findById(adminId)
				.orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + adminId));

		existAdmin.setAdminName(admin.getAdminName());
		existAdmin.setUserName(admin.getUserName());
		existAdmin.setPassword(admin.getPassword());

		return adminRepository.save(existAdmin);
	}

	@Override
	public void deleteAdmin(Long adminId) throws AdminNotFoundException {

		if (!adminRepository.existsById(adminId)) {
			throw new AdminNotFoundException("Admin details not exist cannot remove");
		}

		adminRepository.deleteById(adminId);

	}

	@Override
	public Admin getAdminById(Long adminId) throws AdminNotFoundException {

		Optional<Admin> admin = adminRepository.findById(adminId);
		if (admin.isEmpty())
			throw new AdminNotFoundException("Admin Not Found");

		return admin.get();
	}

	@Override
	public List<Admin> getAllAdmins() {

		return adminRepository.findAll();
	}
	


}
