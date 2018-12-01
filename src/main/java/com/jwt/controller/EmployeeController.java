package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.EmployeData;
import com.jwt.service.EmployeeDataService;


@Controller
public class EmployeeController {

	private static final Logger logger =
	 Logger.getLogger(EmployeeController.class);

	 @Autowired
	 private EmployeeDataService employeeDataService;
	
	 public void setemployeeDataService(EmployeeDataService employeeDataService)
	 {
	 this.employeeDataService = employeeDataService;
	 }

	/*@RequestMapping(value = "/")
	public ModelAndView show() {
		return new ModelAndView("index");
	}*/
	
	  @RequestMapping(value = "/" , method = RequestMethod.GET)
	  public ModelAndView listEmployee(@ModelAttribute("Employee")EmployeData
	  employee){
	  ModelAndView mav=new ModelAndView("home");
	  List<EmployeData> listEmployee = employeeDataService.getAllEmployees();
	  mav.addObject("listEmployee", listEmployee);
	  //mav.setViewName("home");
	  return mav;
	  }
	
	 @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	 public ModelAndView newContact(ModelAndView model) {
	 EmployeData employee = new EmployeData();
	 model.addObject("employee", employee);
	 model.setViewName("EmployeeForm");
	 return model;
	 }
	
	 @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	 public ModelAndView saveEmployee(@ModelAttribute EmployeData employee) {
	 if (employee.getId() == null || employee.getId() == 0) { // if employee id is 0 then creating the
	 // employee other updating the employee
		 employeeDataService.addEmployee(employee);
	 } else {
		 employeeDataService.updateEmployee(employee);
	 }
	 return new ModelAndView("redirect:/");
	 }
	
	 @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	 public ModelAndView deleteEmployee(HttpServletRequest request) {
	 int employeeId = Integer.parseInt(request.getParameter("id"));
	 employeeDataService.deleteEmployee(employeeId);
	 return new ModelAndView("redirect:/");
	 }
	
	 @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	 public ModelAndView editContact(HttpServletRequest request) {
	 int employeeId = Integer.parseInt(request.getParameter("id"));
	 EmployeData employee = employeeDataService.getEmployee(employeeId);
	 ModelAndView model = new ModelAndView("EmployeeForm");
	 model.addObject("employee", employee);
	 return model;
	 }

}