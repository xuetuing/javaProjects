package action;

import java.util.List;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class ListAction {
	private int page = 1;
	private List<Admin> list;
	private int totalPages;
	
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
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

	public String execute(){
		AdminDAO dao = new AdminDAOImpl();
		try {
			list = dao.findAll(page, 3);
			totalPages = dao.getTotalPages(3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
