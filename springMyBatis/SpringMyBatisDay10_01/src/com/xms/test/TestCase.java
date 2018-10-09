package com.xms.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.dao.DeptMapper;
import com.xms.dao.EmpMapper;
import com.xms.dao.QuestionMapper;
import com.xms.entity.Admin;
import com.xms.entity.Dept;
import com.xms.entity.Emp;
import com.xms.entity.Question;
import com.xms.entity.Role;

public class TestCase {
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	DeptMapper deptMapper = ac.getBean("deptMapper",DeptMapper.class);
	EmpMapper empMapper = ac.getBean("empMapper",EmpMapper.class);
	QuestionMapper questionMapper = ac.getBean("questionMapper",QuestionMapper.class);
	
	@Test
	public void testOne(){
		Emp emp = empMapper.findEmpByEmpnoOne(1001);
		System.out.println(emp.getEname()+":"+
						   emp.getDeptno()+" "+    //值为空
						   emp.getDept().getDeptno()+" "+  //有值
						   emp.getDept().getDname());
		
	}
	@Test
	public void testTwo(){
		Emp emp = empMapper.findEmpByEmpnoTwo(1001);
		System.out.println(emp.getEname()+":"+
				emp.getDeptno()+" "+    //值为空
				emp.getDept().getDeptno()+" "+  //有值
				emp.getDept().getDname());
		
	}
	@Test
	public void testThree(){
		Dept dept = deptMapper.findByDeptnoOne(10);
		System.out.println(dept.getDeptno()+":"+dept.getDname()+" "+
						   dept.getAddress());
		for(Emp emp : dept.getEmps()){
			System.out.println(emp.getEmpno()+":"+emp.getEname()+" "+emp.getDeptno());
		}
	}
	@Test
	public void testFour(){
		Dept dept = deptMapper.findByDeptnoTwo(10);
		System.out.println(dept.getDeptno()+":"+dept.getDname()+" "+
				dept.getAddress());
		for(Emp emp : dept.getEmps()){
			System.out.println(emp.getEmpno()+":"+emp.getEname()+" "+emp.getDeptno());
		}
	}
	//鉴别器
	@Test
	public void testFive(){
		List<Question> questions = questionMapper.findAll();
		
		for(Question q : questions){
			System.out.println(q);
			System.out.println(q.getId()+":"+q.getTitle()+" "+q.getType());
			System.out.println("============================");
		}
		
	}
	@Test
	public void testSix(){
		List<Admin> list = deptMapper.findByAdmin();
		for(Admin admin : list){
			System.out.println(admin.getUsername());
			
			for(Role role : admin.getRoles()){
				System.out.println(role.getName());
			}
			
		}
		
	}
	
	
}
