package dao;

import java.util.List;

import entity.Admin;

public interface AdminDAO {
	//�������еļ�¼
	public List<Admin> findAll() throws Exception;
	//��ӹ���Ա
	public void add(Admin admin) throws Exception;
	//ɾ������Ա
	public void del(int id) throws Exception;
	//����id��ѯ����Ա
	public Admin findById(int id) throws Exception;
	//���¹���Ա
	public void update(Admin admin) throws Exception;
	
}
