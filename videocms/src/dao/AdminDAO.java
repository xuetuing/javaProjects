package dao;

import java.util.List;
import java.util.Map;

import entity.Admin;
import entity.Role;

public interface AdminDAO {
	//查找第一页的管理员数据
	public List<Admin> findByPage(int page,int pageSize) throws Exception;
	public int getTotalPages(int pageSize) throws Exception;
	public List<Role> findAllRoles() throws Exception;
	public int addAdmin(Admin admin) throws Exception;
	public void addAdminRole(Map<String, Integer> map) throws Exception;
	public Admin findById(int id) throws Exception;
	public void updateAdmin(Admin admin) throws Exception;
	public void delAdminRole(Integer id) throws Exception;
	public void delAdmin(int id) throws Exception;
	public Admin findByUsername(String username) throws Exception;
}
