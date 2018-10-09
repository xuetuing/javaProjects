package action;

import java.util.List;

import service.UserService;
import entity.User;

public class UserAction {
	//ҵ���������
	UserService uService = new UserService();
	//�������
	private List<User> list;
	//��������
	private int page;
	private int totalPage;
	
	public String execute(){
		try {
			list = uService.findByPage(page, 2);
			totalPage = uService.getTotalPages(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
}
