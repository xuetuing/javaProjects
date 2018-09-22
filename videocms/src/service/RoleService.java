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
		//�޸�Role��Ϣ
		dao.updateRole(role);
		//ɾ����������Ϣ
		dao.delRolePriv(role.getId());
		//������ӹ�����Ϣ
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int id : privIds){
			map.put("role_id", role.getId());
			map.put("priv_id", id);
			dao.addRolePriv(map);
		}
	}

	public void addRole(Role role, int[] privIds) throws Exception{
		//���õ�role��Ӻ��id
		int id = dao.addRole(role);
		//��role_id �� priv_id ��װ
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








