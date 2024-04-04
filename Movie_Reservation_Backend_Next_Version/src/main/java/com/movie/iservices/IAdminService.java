package com.movie.iservices;

import java.util.List;

import com.movie.excpetion.AdminIdExistException;
import com.movie.excpetion.AdminNotFoundException;
import com.movie.entites.Admin;

public interface IAdminService {

	public Admin registerAdmin(Admin Admin) throws AdminIdExistException;

	public Admin updateAdmin(long adminId, Admin Admin) throws AdminNotFoundException;

	public void deleteAdmin(Long AdminId) throws AdminNotFoundException;

	public Admin getAdminById(Long AdminId) throws AdminNotFoundException;

	public List<Admin> getAllAdmins();
	


}
