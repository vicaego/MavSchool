package com.school.students;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StudentsControllers {

	@Autowired
	private StudentsDAO studentsDAO;
	
//	@Autowired
	//private StudentFormValidator validator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/searchStudents")
	public ModelAndView searchStudents(@RequestParam(required= false, defaultValue="") String surname)
	{
		ModelAndView mav = new ModelAndView("showStudents");
		List<Student> students = studentsDAO.searchStudent(surname.trim());
		mav.addObject("SEARCH_STUDENTS_RESULTS_KEY", students);
		return mav;
	}
		
	
	@RequestMapping("/viewAllStudents")
	public ModelAndView getAllStudents()throws Exception
	{
		ModelAndView mav = new ModelAndView("showStudents");
		List<Student> Students = studentsDAO.getAllStudents();	
		mav.addObject("SEARCH_STUDENTS_RESULTS_KEY", Students);
		return mav;
	}
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("newStudent");
		Student Student = new Student();
		mav.getModelMap().put("newStudent", Student);
		return mav;
	}
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public String create(@ModelAttribute("newStudent")Student student, BindingResult result, SessionStatus status)
	{
	//	validator.validate(Student, result);
		if (result.hasErrors()) 
		{				
			return "newStudent";
		}
		studentsDAO.save(student);
		
		
		status.setComplete();
		return "redirect:viewAllStudents.do";
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editStudent");
		Student Student = studentsDAO.getById(id);
		mav.addObject("editStudent", Student);
		return mav;
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.POST)
	public String update(@ModelAttribute("editStudent") Student student, BindingResult result, SessionStatus status)
	{
	//	validator.validate(Student, result);
		if (result.hasErrors()) {
			return "editStudent";
		}
		studentsDAO.update(student);
		status.setComplete();
		return "redirect:viewAllStudents.do";
	}
	
	
	@RequestMapping("deleteStudent")
	public ModelAndView delete(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("redirect:viewAllStudents.do");
		studentsDAO.delete(id);
		return mav;
	}
}
