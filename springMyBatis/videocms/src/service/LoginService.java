package service;

import dao.AdminDAO;
import dao.impl.AdminDAOImpl;
import entity.Admin;

public class LoginService {
	AdminDAO dao = new AdminDAOImpl();

	public Admin findByUsername(String username) throws Exception{
		return dao.findByUsername(username);
	}
	
	
	
}
