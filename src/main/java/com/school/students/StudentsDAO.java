package com.school.students;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentsDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Student getById(int id)
	{
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> searchStudent(String name)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
		criteria.add(Restrictions.ilike("surname", name+"%"));
		 System.out.println(">>>>>>>>>>>>>>> "+name);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
		return criteria.list();
	}
	
	
	public int save(Student student)
	{
		return (Integer) sessionFactory.getCurrentSession().save(student);
	}
	
	public void update(Student student)
	{
		sessionFactory.getCurrentSession().merge(student);
	}
	
	public void delete(int id)
	{
		Student c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}
	
}
