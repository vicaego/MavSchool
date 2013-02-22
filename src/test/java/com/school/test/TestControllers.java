package com.school.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.school.students.Student;
import com.school.students.StudentsDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)

@Controller
public class TestControllers {

	@Autowired
	private StudentsDAO testDAO;
	
	@Test
	public void testStudent(){
		Student student = new Student();
		student.setSurname("Junit");
		student.setForename("o");
		
		testDAO.save(student);
	}
	
	
}
