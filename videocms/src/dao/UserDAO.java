package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	public List<User> findByPage(int page,int pageSize) throws Exception;
	public int getTotalPages(int pageSize) throws Exception;
	
}
