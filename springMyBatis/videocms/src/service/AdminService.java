package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AdminDAO;
import dao.impl.AdminDAOImpl;
import entity.Admin;
import entity.Role;

public class AdminService {
	AdminDAO dao = new AdminDAOImpl();
	
	public List<Admin> findByPage(int page,int pageSize) throws Exception{
		return dao.findByPage(page, pageSize);
	}
	
	public int getTotalPages(int pageSize) throws Exception {
		return dao.getTotalPages(pageSize);
	}
	
	public List<Role> findAllRoles() throws Exception{
		return dao.findAllRoles();
	}
//	public static void main(String[] args) throws Exception {
//		System.out.println(new AdminService().findAllRoles().size());
//	}

	public void addAdmin(Admin admin, int[] roleIds) throws Exception{
			//将admin入库
			int id = dao.addAdmin(admin);
			//将adminid和角色id入库
			Map<String,Integer> map = new HashMap<String,Integer>();
			for(int rid : roleIds){
				map.put("admin_id",id);
				map.put("role_id",rid);
				dao.addAdminRole(map);
			}
	}

	public Admin findById(int id) throws Exception{
		return dao.findById(id);
	}

	public void updateAdmin(Admin admin, int[] roleIds) throws Exception{
		//更新admin数据
		dao.updateAdmin(admin);
		//更新admin_role数据
		//1.删除记录  2.重新插入记录
		dao.delAdminRole(admin.getId());
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int rid : roleIds){
			map.put("admin_id",admin.getId());
			map.put("role_id",rid);
			dao.addAdminRole(map);
		}
	}

	public void delAdminById(int id) throws Exception{
		dao.delAdmin(id);
		dao.delAdminRole(id);
	}

}
