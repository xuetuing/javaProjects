package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;

import util.DBUtil;
import bean.SearchCondition;
import dao.ProductDAO;
import entity.Course;
import entity.Lore;
import entity.Product;

public class ProductDAOImpl implements ProductDAO{

	public List<Course> findAllCourse() throws Exception {
		Connection con = DBUtil.getConnection();
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Course course = null;
		while(rs.next()){
			course = new Course();
			course.setId(rs.getInt("id"));
			course.setName(rs.getString("name"));
			list.add(course);
		}
		DBUtil.close(con);
		return list;
	}

//	public static void main(String[] args) throws Exception {
//		System.out.println(new ProductDAOImpl().findAllCourse().size());
//	}

	public List<Lore> findLores(int courseId) throws Exception {
		Connection con = DBUtil.getConnection();
		List<Lore> lores = new ArrayList<Lore>();
		String sql = "select * from lore where course_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseId);
		ResultSet rs = ps.executeQuery();
		Lore lore = null;
		while(rs.next()){
			lore = new Lore();
			lore.setId(rs.getInt("id"));
			lore.setName(rs.getString("name"));
			lores.add(lore);
		}
		DBUtil.close(con);
		return lores;
	}

	public void addProduct(Product product) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into product values(null,?,?,?,?,?,?,?,?,?,now())";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,product.getName());
		ps.setInt(2,product.getCourse_id());
		ps.setInt(3,product.getLore_id());
		ps.setString(4,product.getDiscription());
		ps.setString(5, product.getStatus());
		ps.setDouble(6,product.getPrice());
		ps.setString(7,product.getImage());
		ps.setString(8,product.getVideo()); 
		ps.setString(9,product.getCreater()); //创建者
		ps.executeUpdate();
		DBUtil.close(con);
		
	}
	//根据查询条件查询对应的数据
	public List<Product> findProducts(SearchCondition cond) throws Exception {
		Connection con = DBUtil.getConnection();
		List<Product> list = new ArrayList<Product>();
		String sql = "select p.*,c.name cname from product p join course c on p.course_id=c.id where 1=1"; 
		//如果分页时有其他查询条件  
		//如果查询条件中有课程方向
		if(!StringUtils.isBlank(cond.getCourseName())){
			sql += " and c.name= '"+cond.getCourseName()+"'";
		}
		//如果查询条件中有课程名称
		if(!StringUtils.isBlank(cond.getProductName())){
			sql += " and p.name = '"+cond.getProductName()+"'";
		}
		//如果查询条件中有上传者
		if(!StringUtils.isBlank(cond.getCreater())){
			sql += " and p.creater like '%"+cond.getCreater()+"%'";
		}
		//如果查询条件中有上传时间，且不为"-请选择-"
		if(!StringUtils.isBlank(cond.getCreatetime())&&!"-请选择-".equals(cond.getCreatetime())){
			sql += " and p.createtime like '%"+cond.getCreatetime()+"%'";
		}
		sql += " limit ?,?";
		//System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		int begin = (cond.getPage() - 1) * cond.getPageSize();
		ps.setInt(1,begin);
		ps.setInt(2,cond.getPageSize());
		ResultSet rs = ps.executeQuery();
		list = getProducts(rs);
		
		DBUtil.close(con);
		return list;
	}
	//根据结果集封装对象
	public List<Product> getProducts(ResultSet rs){
		List<Product> products = new ArrayList<Product>();
		Product product = null;
		Course c = null;
		try {
			while(rs.next()){
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setCourse_id(rs.getInt("course_id"));
				product.setLore_id(rs.getInt("lore_id"));
				product.setDiscription(rs.getString("discription"));
				product.setCreatetime(rs.getDate("create_time"));
				product.setImage(rs.getString("image"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setStatus(rs.getString("status"));
				product.setVideo(rs.getString("video"));
				product.setCreater(rs.getString("creater"));
				c = new Course();
				c.setId(rs.getInt("course_id"));
				c.setName(rs.getString("cname"));
				product.setC(c);
				
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public int getTotalpages(SearchCondition cond) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select count(*) from product p join course c on p.course_id=c.id where 1=1";
		//如果分页时有其他查询条件  
		//如果查询条件中有课程方向
		if(!StringUtils.isBlank(cond.getCourseName())){
			sql += " and c.name= '"+cond.getCourseName()+"'";
		}
		//如果查询条件中有课程名称
		if(!StringUtils.isBlank(cond.getProductName())){
			sql += " and p.name = '"+cond.getProductName()+"'";
		}
		//如果查询条件中有上传者
		if(!StringUtils.isBlank(cond.getCreater())){
			sql += " and p.creater like '%"+cond.getCreater()+"%'";
		}
		//如果查询条件中有上传时间，且不为"-请选择-"
		if(!StringUtils.isBlank(cond.getCreatetime())&&!"-请选择-".equals(cond.getCreatetime())){
			sql += " and p.createtime like '%"+cond.getCreatetime()+"%'";
		}
	
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt(1);
		DBUtil.close(con);
		int pageSize = cond.getPageSize();
		int totalPage = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		return totalPage;
	}

	public void delProdById(int id) throws Exception{
		Connection con = DBUtil.getConnection();
		String sql = "delete from product where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public Product findProdById(int id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select p.*,c.name cname from product p join course c on p.course_id=c.id where p.id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Product product = null;
		while(rs.next()){
			product = new Product();
			product.setId(rs.getInt("id"));
			product.setCourse_id(rs.getInt("course_id"));
			product.setLore_id(rs.getInt("lore_id"));
			product.setDiscription(rs.getString("discription"));
			product.setCreatetime(rs.getDate("create_time"));
			product.setImage(rs.getString("image"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			product.setStatus(rs.getString("status"));
			product.setVideo(rs.getString("video"));
			product.setCreater(rs.getString("creater"));
			Course c = new Course();
			c.setId(rs.getInt("course_id"));
			c.setName(rs.getString("cname"));
			product.setC(c);
		}
		DBUtil.close(con);
		return product;
	}
//	public static void main(String[] args) throws Exception {
//		System.out.println(new ProductDAOImpl().findProdById(1).getName());
//	}
	
}





