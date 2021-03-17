/*
* Class name:-HomeController 

* Author:- Vikas Tiwari

* Created on:- 12th March 2021

* Last Updated by:- Vikas Tiwari

* Last Updated on:- 16th January 2021

* Description:-  make a controller Class.
*/

package com.hrmanager.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hrmanager.dao.HrDao;
import com.hrmanager.entities.Employee;
import com.hrmanager.entities.HrManager;
import com.hrmanager.service.EmployeeService;




@Controller
public class HomeController {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HrDao hrDao;
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private Employee employee;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(path = "/home", method = {RequestMethod.POST,RequestMethod.GET})
	public String home(@ModelAttribute HrManager hr,
			@RequestParam("userName") String userName, @RequestParam("password") String password,Model m,HttpServletRequest req)
	{
		List<HrManager> users = hrDao.getManagers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userName) && users.get(i).getPassword().equals(password)) {
				HttpSession httpSession=req.getSession();
				httpSession.setAttribute("user",userName);
				List<Employee> employees=this.service.getAllEmployee();
				
			    m.addAttribute("employees",employees);

				return "home";
			}
		}	
		return "error";
	}
	
	@RequestMapping("/back")
	public String home(Model m)
	{
		List<Employee> employees=this.service.getAllEmployee();
		 m.addAttribute("employees",employees);
		 return "home";
	}
	
	@RequestMapping("/edit")
	public String edit()
	{
		
		return "edit";
	}
	
	@RequestMapping("/updateEmployee")
    public String updateDetails(HttpServletRequest request, HttpServletResponse response,Model m) {        
        int empcode = Integer.parseInt(request.getParameter("code"));
        String empname = request.getParameter("name");
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String email = request.getParameter("email");
        Date date = null;
        try {
            date = dateFormat.parse(request.getParameter("date"));
        } catch (Exception e) {
            System.out.println("parsing error" + e);
        }

 

        String location = request.getParameter("location");    
        employee.setEmployeeCode(empcode);
        employee.setEmail(email);
        employee.setDob(date);
        employee.setEmployeeName(empname);
        employee.setLocation(location);
        service.updateEmployee(employee);
        List<Employee> employeeList = service.getAllEmployee();
        m.addAttribute("employees", employeeList);
        return "home";
    }
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req)
	{
		req.getSession().invalidate(); // null the current session
		return "login";
	}
}
