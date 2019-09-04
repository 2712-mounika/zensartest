package com.test.service;

import com.test.dao.TestDAO;
import com.test.dao.TestDAOInterface;
import com.test.entity.TestEmployee;

public class TestService implements TestServiceInterface{
	private TestService() {}

	public int createProfile(TestEmployee te) {
		// TODO Auto-generated method stub
		TestDAOInterface td=TestDAO.createDaoObject();
		return td.createProfileDAO(te);
	}

	public static TestServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new TestService();
	}

}
