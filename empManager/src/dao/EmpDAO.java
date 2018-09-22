package dao;

import java.util.List;

import entity.Emp;
import entity.User;

public interface EmpDAO {
	//�б�ҳȫ����Ϣ
	public List<Emp> findAll() throws Exception;
	//���ҵ�����¼ ����ɾ�����޸�
	public Emp findById(int id) throws Exception;
	//����empԱ��
	public void add_emp(Emp emp) throws Exception;
	//�޸�emp��Ϣ
	public void update_emp(Emp emp) throws Exception;
	//ɾ��emp��¼
	public void del_emp(int id) throws Exception;
	//ע��user
	public void add_user(User user) throws Exception;
	//��¼��ѯ
	public User findByUsername(String username) throws Exception;
}
