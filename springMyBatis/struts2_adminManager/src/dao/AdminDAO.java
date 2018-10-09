package dao;

import java.util.List;

import entity.Admin;

public interface AdminDAO {
	//查找所有的记录
	public List<Admin> findAll(int page,int pageSize) throws Exception;
	//添加管理员
	public void add(Admin admin) throws Exception;
	//删除管理员
	public void del(int id) throws Exception;
	//根据id查询管理员
	public Admin findById(int id) throws Exception;
	//更新管理员
	public void update(Admin admin) throws Exception;
	//根据账号查询管理员
	public Admin findByUsername(String username) throws Exception;
	//账号密码校验
//	public boolean checkUsernameAndPwd(String username,String password)
//									throws Exception;
	public int getTotalPages(int pageSize) throws Exception;
}
