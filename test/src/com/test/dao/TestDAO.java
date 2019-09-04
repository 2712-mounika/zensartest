package com.test.dao;

import java.sql.PreparedStatement;

import javax.jms.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.test.entity.TestEmployee;

public class TestDAO implements TestDAOInterface{

	@Override
	public int createProfileDAO(TestEmployee te) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			
			Context initCtx = new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:/zomato"); 
			
			Connection con=(Connection) ds.getConnection();
			PreparedStatement ps=((java.sql.Connection) con).prepareStatement("insert into TestEmployee values(?,?)");
			ps.setString(1, te.getEmail());
			ps.setString(2, te.getPassword());
			
			i=ps.executeUpdate();
			System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}


	public static TestDAOInterface createDaoObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
