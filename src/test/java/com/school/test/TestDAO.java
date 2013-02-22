package com.school.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.transaction.TransactionConfiguration;


import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import com.school.students.*;


@Repository
@Transactional
@TransactionConfiguration(defaultRollback = true)

public class TestDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	
	public void testStudent(Student student){
		
	try
	{
		sessionFactory.getCurrentSession().save(student);
		
		System.out.println("test");
	}catch(Exception ex){
		ex.printStackTrace();
		}
	}
	
}





