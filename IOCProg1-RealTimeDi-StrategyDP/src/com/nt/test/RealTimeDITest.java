package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

public class RealTimeDITest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		BeanFactory factory=null;
		MainController controller=null;
		Scanner sc=null;
		String sno=null,sadd=null,sname=null,m1=null,m2=null,m3=null;
		StudentVO vo=null;
		String result=null;
		//create IOC container
		
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		
		//get controller class obeject
		
		controller=factory.getBean("controller",MainController.class);
		sc=new Scanner(System.in);
		
		System.out.println("Enter Student No");
		sno=sc.next();
		System.out.println("Enter Student Name");
		sname=sc.next();
		System.out.println("Enter Student Add");
		sadd=sc.next();
		System.out.println("Enter Student Marks1");
		m1=sc.next();
		System.out.println("Enter Student Marks2");
		m2=sc.next();
		System.out.println("Enter Student Marks3");
		m3=sc.next();
		
		//prepare vo class object
		vo=new StudentVO();
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setSadd(sadd);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		
		//invoike method
		try {
			result=controller.handleStudet(vo);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			System.out.println("student regsitraion failed");
		}
	}

}
