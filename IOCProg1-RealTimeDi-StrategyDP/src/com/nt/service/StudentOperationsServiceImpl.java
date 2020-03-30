package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public final class StudentOperationsServiceImpl implements StudentOpertaionsService {
	
	private StudentDAO dao;
	
	
	
	
	public StudentOperationsServiceImpl(StudentDAO dao) {
		System.out.println("StudentOperationsServiceImpl::1 param Constructor");
		
		this.dao = dao;
	}




	@Override
	public String register(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		int count=0;
		//write business logic to total,avg and result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(dto.getM1()<35 || dto.getM2()<35 || dto.getM3()<35)
		
		result="fail";
		else
			result="pass";
		
		//prepae Bo class Obj Persistale Data
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		//use dao
		
		
		count=dao.insert(bo);
		
		//prcess the result
		if(count==0)
			return "Student Registration Failed";
		else
			return "Student Registereation Succeded and total="+total+"avg="+avg+"result="+result;
	}

}
