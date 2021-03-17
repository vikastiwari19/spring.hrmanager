/*
* Class name:-HrServices

* Author:- Vikas Tiwari

* Created on:- 12th March 2021

* Last Updated by:- Vikas Tiwari

* Last Updated on:- 16th March 2021

* Description:-  make a HrServices Class to perform a operation on hr.
*/

package com.hrmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrmanager.dao.HrDao;
import com.hrmanager.entities.HrManager;

@Service
public class HrServices {

	public HrDao getHrDao() {
		return HrDao;
	}
	public void setHrDao(HrDao hrDao) {
		HrDao = hrDao;
	}
	@Autowired
	private HrDao HrDao;

	public void createFlight(HrManager hr)
	{
	 
		this.HrDao.create(hr);
	}
	

	
}
