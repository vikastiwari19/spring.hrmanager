/*
* Class name:-HrDao 

* Author:- Vikas Tiwari

* Created on:- 12th March 2021

* Last Updated by:- Vikas Tiwari

* Last Updated on:- 16th January 2021

* Description:-  make a HrDao Class to save a data in a database using hibernateTemplate.
*/

package com.hrmanager.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hrmanager.entities.HrManager;


@Repository
public class HrDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void create(HrManager hr)
	{
		
		this.hibernateTemplate.saveOrUpdate(hr);
	}
	
	public List<HrManager> getManagers() {
		List<HrManager> flights = this.hibernateTemplate.loadAll(HrManager.class);
		return flights;
	}

	
	
}

