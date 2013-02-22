package com.school.students;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;



@Entity
@Table(name="Student")
public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column	private String surname;
	@Column private String forename; 
	@Column private String address; 
	@Column private Date dob; 

	
	public Student()
	{
	}
	
	public Student(int id, String surname, String forename, String address,Date dob)
	{
		super();
		this.id = id;
		this.surname = surname;
		this.forename = forename;
		this.address = address;
		this.dob = dob;
	}
	
	
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
	
	

}
