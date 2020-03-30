package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public final class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_STUDEMT_QUERY="INSERT INTO SPRING_LAYERED_STUDENT VALUES(?,?,?,?,?,?)";
	private DataSource ds;


	public StudentDAOImpl(DataSource ds) {
		System.out.println("StudentDAOImpl::1-param consturctor");
		this.ds = ds;
	}


	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con =null;
		PreparedStatement ps=null;
		int count=0;

		//get Pooled Jdbc con object using injected DataSource object
		con=ds.getConnection();
		//cerate JDBC PreparedStatement object having preCompiled SQL Query
		ps=con.prepareStatement(INSERT_STUDEMT_QUERY);

		//set value to query param gathering BO class Object
		
		ps.setInt(1,bo.getSno());
		ps.setString(2,bo.getSname());
		ps.setString(3,bo.getSadd());
		ps.setInt(4,bo.getTotal());
		ps.setFloat(5,bo.getAvg());
		ps.setString(6, bo.getResult());

		count=ps.executeUpdate();
		
		return count;
	}

}
