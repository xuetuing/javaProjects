package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.ProductService;
import bean.ResponseBody;
import bean.SearchCondition;
import entity.Course;
import entity.Lore;
import entity.Product;

public class ProductAction extends BaseAction{
	ProductService ps = new ProductService();
	//输入属性
	private int courseId;
	private Product product;
	private int page;
	private SearchCondition cond;
	private int id;
	private boolean imgFlag;
	private boolean videoFlag;
	//输出属性
	private List<Course> courses;
	private List<Lore> lores;
	private ResponseBody body;
	

	public String loadCourse(){
		try {
			courses = ps.findAllCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String loadLore(){
		try {
			lores = ps.findLores(courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String addProduct(){
		try {
			//给上传者赋值
			product.setCreater("会飞的鱼");
			ps.addProduct(product);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("提交成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String list(){
		try {
			List<Product> list = new ArrayList<Product>();
			list = ps.findProducts(cond);
			int totalPage = ps.getTotalpages(cond);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("查询成功");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("list",list);
			map.put("totalPage",totalPage);
			body.setObj(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String updateProd(){
		try {
			ps.updateProd(product,imgFlag,videoFlag,sc);
			
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String del(){
		try {
			ps.delById(id,sc);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String loadOneProd(){
		try {
			product = ps.findProdById(id);
			body = new ResponseBody();
			body.setCode("000");
			body.setMsg("加载成功");
			body.setObj(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public List<Lore> getLores() {
		return lores;
	}
	public void setLores(List<Lore> lores) {
		this.lores = lores;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ResponseBody getBody() {
		return body;
	}
	public void setBody(ResponseBody body) {
		this.body = body;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public SearchCondition getCond() {
		return cond;
	}
	public void setCond(SearchCondition cond) {
		this.cond = cond;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isImgFlag() {
		return imgFlag;
	}
	public void setImgFlag(boolean imgFlag) {
		this.imgFlag = imgFlag;
	}
	public boolean isVideoFlag() {
		return videoFlag;
	}
	public void setVideoFlag(boolean videoFlag) {
		this.videoFlag = videoFlag;
	}
	
	
}
