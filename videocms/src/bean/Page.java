package bean;
/**
 * ���幫��page
 * @author Administrator
 *
 */
public class Page {
	private int page;
	private int pageSize = 2;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
