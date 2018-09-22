package service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import util.FileUtil;

import bean.SearchCondition;
import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import entity.Course;
import entity.Lore;
import entity.Product;

public class ProductService {
	ProductDAO dao = new ProductDAOImpl();
	
	public List<Course> findAllCourse() throws Exception {
		return dao.findAllCourse();
	}

	public List<Lore> findLores(int courseId) throws Exception{
		return dao.findLores(courseId);
	}

	public void addProduct(Product product) throws Exception{
		dao.addProduct(product);
	}

	public List<Product> findProducts(SearchCondition cond) throws Exception{
		return dao.findProducts(cond);
	}

	public int getTotalpages(SearchCondition cond) throws Exception{
		return dao.getTotalpages(cond);
	}

	public void delById(int id,ServletContext sc) throws Exception{
		//删除产品对应的图片 文件
		//1.根据id找到产品信息，取出对应的图片名称
		Product p = dao.findProdById(id);
		//2.拼接文件路径，删除文件
		String imgPath = "upload\\" + p.getImage();
		String videoPath = "upload\\" + p.getVideo();
		File img = new File(sc.getRealPath(imgPath));
		File video = new File(sc.getRealPath(videoPath));
		FileUtil.delFile(img);
		FileUtil.delFile(video);
		//删除表中的记录
		dao.delProdById(id);
	}

	public Product findProdById(int id) throws Exception{
		return dao.findProdById(id);
	}

	public void updateProd(Product product, boolean imgFlag, 
			boolean videoFlag, ServletContext sc) throws Exception{
		//删除记录
		Product p = dao.findProdById(product.getId());
		//1.根据flag判断图片和视频是否要删
		if(imgFlag){
			String imgPath = "upload\\" + p.getImage();
			File img = new File(sc.getRealPath(imgPath));
			FileUtil.delFile(img);
		}
		if(videoFlag){
			String videoPath = "upload\\" + p.getVideo();
			File video = new File(sc.getRealPath(videoPath));
			FileUtil.delFile(video);
		}
		//2.删除记录
		dao.delProdById(product.getId());
		//添加记录
		dao.addProduct(product);
	}
}
