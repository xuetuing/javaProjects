package action;

import java.util.List;

import bean.ResponseBody;

import service.RoleService;
import entity.Privilege;
import entity.Role;

public class RoleAction {
	RoleService rs = new RoleService();
	//输入属性
	private int page;
	private int id;
	private Role role;
	private int[] privIds; //接收添加成员页面传回的权限id
	private int[] ids; //选择删除记录的id集合
	//输出属性
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
			body.setMsg("添加成功");
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
			body.setMsg("回显成功");
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
			body.setMsg("修改成功");
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
			body.setMsg("删除成功");
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
