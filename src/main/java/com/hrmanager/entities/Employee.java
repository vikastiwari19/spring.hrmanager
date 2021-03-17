/*
* Class name:-Employee 

* Author:- Vikas Tiwari

* Created on:- 12th March 2021

* Last Updated by:- Vikas Tiwari

* Last Updated on:- 16th March 2021

* Description:-  make a Employee Class as a Employee Entity.
*/

package com.hrmanager.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

		public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int employeeCode;
		
		@Column(name="Employee_Name")
		private String employeeName;
		@Column(name="Location")
		private String location;
	
		@Column(name="Email")
		private String email;
		@Column(name="Date_Of_Birth")
		private Date dob;
		public int getEmployeeCode() {
			return employeeCode;
		}
		public void setEmployeeCode(int employeeCode) {
			this.employeeCode = employeeCode;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public Employee(int employeeCode, String employeeName, String location, String email, Date dob) {
			super();
			this.employeeCode = employeeCode;
			this.employeeName = employeeName;
			this.location = location;
			this.email = email;
			this.dob = dob;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Employee [employeeCode=" + employeeCode + ", employeeName=" + employeeName + ", location=" + location
					+ ", email=" + email + ", dob=" + dob + "]";
		}
		

}
