package action;

import java.util.List;

import bean.ResponseBody;

import service.AdminService;
import entity.Admin;
import entity.Role;

public class AdminAction {
	//操作对象
	AdminService aService = new AdminService(); 
	//输出属性
	private List<Admin> list;
	private List<Role> roles;  //所有的角色
	private String responseStr; //用于存放状态，提示等信息
	private int totalPage;
	//输入属性
	private int page;
	private Admin admin;  //新增时的输入，修改时的查询输出
	private int[] roleIds; //接收页面传入的角色id
	private int id;
	private int[] ids;
	private ResponseBody body; //模拟返回的响应实体
	
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
	//添加Admin
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
			//手动返回一个json格式字符串给页面
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
		body.setMsg("删除成功");
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
