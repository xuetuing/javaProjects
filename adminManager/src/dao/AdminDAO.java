package dao;

import java.util.List;

import entity.Admin;

public interface AdminDAO {
	//�������еļ�¼
	public List<Admin> findAll(int page,int pageSize) throws Exception;
	//��ӹ���Ա
	public void add(Admin admin) throws Exception;
	//ɾ������Ա
	public void del(int id) throws Exception;
	//����id��ѯ����Ա
	public Admin findById(int id) throws Exception;
	//���¹���Ա
	public void update(Admin admin) throws Exception;
	//�����˺Ų�ѯ����Ա
	public Admin findByUsername(String username) throws Exception;
	//�˺�����У��
//	public boolean checkUsernameAndPwd(String username,String password)
//									throws Exception;
	public int getTotalPages(int pageSize) throws Exception;
}
