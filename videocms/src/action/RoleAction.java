package action;

import java.util.List;

import bean.ResponseBody;

import service.RoleService;
import entity.Privilege;
import entity.Role;

public class RoleAction {
	RoleService rs = new RoleService();
	//��������
	private int page;
	private int id;
	private Role role;
	private int[] privIds; //������ӳ�Աҳ�洫�ص�Ȩ��id
	private int[] ids; //ѡ��ɾ����¼��id����
	//�������
	private int totalPage;
	private List<Role> list;
	private List<Privilege> privs;
	private ResponseBody body;

	public String roleList(){
		try {
			list = rs.findByPage(page, 2);
			totalPage = rs.getTotalPages(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String privList(){
		try {
			privs = rs.findAllPrivs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String addRole(){
		try {
			rs.addRole(role,privIds);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("��ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String loadOneRole(){
		try {
			role = rs.findById(id);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("���Գɹ�");
			body.setObj(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String updateRole(){
		try {
			rs.updateRole(role,privIds);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("�޸ĳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String delRole(){
		try {
			rs.delRole(ids);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("ɾ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	
	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Privilege> getPrivs() {
		return privs;
	}

	public void setPrivs(List<Privilege> privs) {
		this.privs = privs;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getPrivIds() {
		return privIds;
	}

	public void setPrivIds(int[] privIds) {
		this.privIds = privIds;
	}

	public ResponseBody getBody() {
		return body;
	}

	public void setBody(ResponseBody body) {
		this.body = body;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
}
