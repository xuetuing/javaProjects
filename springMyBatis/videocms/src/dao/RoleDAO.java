package dao;

import java.util.List;
import java.util.Map;

import entity.Privilege;
import entity.Role;

public interface RoleDAO {
	public List<Role> findByPage(int page,int pageSize) throws Exception;
	public int getTotalPages(int pageSize) throws Exception;
	public List<Privilege> findAllPrivs() throws Exception;
	public Role findById(int id) throws Exception;
	public int addRole(Role role) throws Exception;
	public void addRolePriv(Map<String,Integer> map) throws Exception;
	public void updateRole(Role role) throws Exception;
	public void delRolePriv(Integer id) throws Exception;
	public void delRoleById(Integer id) throws Exception;
	
}
