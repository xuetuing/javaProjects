package dao;

import java.util.List;

import entity.Emp;
import entity.User;

public interface EmpDAO {
	//列表页全部信息
	public List<Emp> findAll() throws Exception;
	//查找单个记录 用于删除，修改
	public Emp findById(int id) throws Exception;
	//增加emp员工
	public void add_emp(Emp emp) throws Exception;
	//修改emp信息
	public void update_emp(Emp emp) throws Exception;
	//删除emp记录
	public void del_emp(int id) throws Exception;
	//注册user
	public void add_user(User user) throws Exception;
	//登录查询
	public User findByUsername(String username) throws Exception;
}
