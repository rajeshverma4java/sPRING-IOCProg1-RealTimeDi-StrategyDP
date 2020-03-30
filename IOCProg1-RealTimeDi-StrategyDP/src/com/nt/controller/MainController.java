package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentOpertaionsService;
import com.nt.vo.StudentVO;

public final class MainController {

	private StudentOpertaionsService service;

	public MainController(StudentOpertaionsService service) {
		System.out.println("MainController::1 param constructor");
		this.service = service;
	}
	
	public String handleStudet(StudentVO vo) throws Exception{
		StudentDTO dto=null;
		String result=null;
		
		//convert Vo to Dto
		
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		
		//use service
		result=service.register(dto);
		return result;
		
	}
}
