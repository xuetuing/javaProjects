package service;

import java.util.List;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;

//会员页面的所有业务操作
public class UserService {
	UserDAO dao = new UserDAOImpl();
	
	public List<User> findByPage(int page,int pageSize) throws Exception{
		return dao.findByPage(page, pageSize);
	}
	
	public int getTotalPages(int pageSize) throws Exception{
		return dao.getTotalPages(pageSize);
	}
}
