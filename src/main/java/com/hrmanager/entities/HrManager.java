/*
* Class name:-HrManager 

* Author:- Vikas Tiwari

* Created on:- 12th March 2021

* Last Updated by:- Vikas Tiwari

* Last Updated on:- 16th March 2021

* Description:-  make a HrManager Class as a Hrmanager Entity.
*/

package com.hrmanager.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HrManager {


		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String userName;
		private String password;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public HrManager(String userName, int id, String password) {
			super();
			this.userName = userName;
			this.id = id;
			this.password = password;
		}
		public HrManager() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public String toString() {
			return "HrManager [id=" + id + ", userName=" + userName + ", password=" + password + "]";
		}
		
		
}

