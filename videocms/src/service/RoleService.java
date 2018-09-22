package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.RoleDAO;
import dao.impl.RoleDAOImpl;
import entity.Privilege;
import entity.Role;

public class RoleService {
	RoleDAO dao = new RoleDAOImpl();
	public List<Role> findByPage(int page,int pageSize) throws Exception {
		return dao.findByPage(page, pageSize);
	}
	
	public int getTotalPages(int pageSize) throws Exception{
		return dao.getTotalPages(pageSize);
	}

	public List<Privilege> findAllPrivs() throws Exception{
		return dao.findAllPrivs();
	}

	public Role findById(int id) throws Exception{
		return dao.findById(id);
	}

	public void updateRole(Role role, int[] privIds) throws Exception{
		//修改Role信息
		dao.updateRole(role);
		//删除关联表信息
		dao.delRolePriv(role.getId());
		//重新添加关联信息
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int id : privIds){
			map.put("role_id", role.getId());
			map.put("priv_id", id);
			dao.addRolePriv(map);
		}
	}

	public void addRole(Role role, int[] privIds) throws Exception{
		//先拿到role添加后的id
		int id = dao.addRole(role);
		//将role_id 和 priv_id 封装
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i : privIds){
			map.put("role_id", id);
			map.put("priv_id", i);
			dao.addRolePriv(map);
		}
		
	}

	public void delRole(int[] ids) throws Exception{
		for(int id : ids){
			dao.delRoleById(id);
			dao.delRolePriv(id);
		}
	}

}








