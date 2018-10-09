package action;

import java.util.List;

import bean.ResponseBody;

import service.AdminService;
import entity.Admin;
import entity.Role;

public class AdminAction {
	//��������
	AdminService aService = new AdminService(); 
	//�������
	private List<Admin> list;
	private List<Role> roles;  //���еĽ�ɫ
	private String responseStr; //���ڴ��״̬����ʾ����Ϣ
	private int totalPage;
	//��������
	private int page;
	private Admin admin;  //����ʱ�����룬�޸�ʱ�Ĳ�ѯ���
	private int[] roleIds; //����ҳ�洫��Ľ�ɫid
	private int id;
	private int[] ids;
	private ResponseBody body; //ģ�ⷵ�ص���Ӧʵ��
	
	public String adminList(){
		try {
			list = aService.findByPage(page, 2);
			totalPage = aService.getTotalPages(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String roleList(){
		try {
			roles = aService.findAllRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	//���Admin
	public String addAdmin(){
		try {
			aService.addAdmin(admin,roleIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String loadAdmin(){
		try {
			admin = aService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String updateAdmin(){
		try {
			aService.updateAdmin(admin,roleIds);
			//�ֶ�����һ��json��ʽ�ַ�����ҳ��
			responseStr = "{'code':'0','msg':'ok'}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String delAdmin(){
		for(int id : ids){
			try {
				aService.delAdminById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		body = new ResponseBody();
		body.setCode("000");
		body.setMsg("ɾ���ɹ�");
		return "success";
	}

	public List<Admin> getList() {
		return list;
	}

	public void setList(List<Admin> list) {
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponseStr() {
		return responseStr;
	}

	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public ResponseBody getBody() {
		return body;
	}

	public void setBody(ResponseBody body) {
		this.body = body;
	}
	
}
