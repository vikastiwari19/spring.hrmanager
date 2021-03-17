/*
* Class name:-EmployeeService 

* Author:- Vikas Tiwari

* Created on:- 12th March 2021

* Last Updated by:- Vikas Tiwari

* Last Updated on:- 16th March 2021

* Description:-  make a EmployeeService Class to use a Rest API functionality in a Application.
*/

package com.hrmanager.service;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrmanager.entities.Employee;
import com.hrmanager.restapi.RestServices;

@Service
public class EmployeeService {

	public static void addEmployee(Employee emp)
	{
		RestServices.addEmployee(emp);
	}
	
	public static List<Employee> getAllEmployee()
	{
		return RestServices.getAllEmployee();
	}
	
	public static Employee getEmployeeById(int id)
	{
		return RestServices.getEmployeeById(id);
	}
	
	public static void updateEmployee(Employee emp)
	{
		RestServices.updateEmployee(emp);
	}
	
	public static void deleteEmployee(int id)
	{
		RestServices.deleteEmployee(id);
	}
	
	public static String changeDate(Date date) {
        String changedDate;
        DecimalFormat dayFormat = new DecimalFormat("00");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        changedDate = dayFormat.format(
                cal.get(Calendar.DATE)) + "/"
                + (cal.get(Calendar.MONTH) + 1) + "/"
                + cal.get(Calendar.YEAR);
        return changedDate;
    }
	
	
	
}
