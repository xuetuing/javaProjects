package dao;

import java.util.List;

import javax.servlet.ServletContext;

import bean.SearchCondition;

import entity.Course;
import entity.Lore;
import entity.Product;

public interface ProductDAO {
	public List<Course> findAllCourse() throws Exception;

	public List<Lore> findLores(int courseId) throws Exception;

	public void addProduct(Product product) throws Exception;

	public List<Product> findProducts(SearchCondition cond) throws Exception;

	public int getTotalpages(SearchCondition cond) throws Exception;

	public Product findProdById(int id) throws Exception;

	public void delProdById(int id) throws Exception;
	
}
