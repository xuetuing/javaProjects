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
		//ɾ����Ʒ��Ӧ��ͼƬ �ļ�
		//1.����id�ҵ���Ʒ��Ϣ��ȡ����Ӧ��ͼƬ����
		Product p = dao.findProdById(id);
		//2.ƴ���ļ�·����ɾ���ļ�
		String imgPath = "upload\\" + p.getImage();
		String videoPath = "upload\\" + p.getVideo();
		File img = new File(sc.getRealPath(imgPath));
		File video = new File(sc.getRealPath(videoPath));
		FileUtil.delFile(img);
		FileUtil.delFile(video);
		//ɾ�����еļ�¼
		dao.delProdById(id);
	}

	public Product findProdById(int id) throws Exception{
		return dao.findProdById(id);
	}

	public void updateProd(Product product, boolean imgFlag, 
			boolean videoFlag, ServletContext sc) throws Exception{
		//ɾ����¼
		Product p = dao.findProdById(product.getId());
		//1.����flag�ж�ͼƬ����Ƶ�Ƿ�Ҫɾ
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
		//2.ɾ����¼
		dao.delProdById(product.getId());
		//��Ӽ�¼
		dao.addProduct(product);
	}
}
