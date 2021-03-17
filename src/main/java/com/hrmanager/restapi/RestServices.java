/*
* Class name:-RestServices

* Author:- Vikas Tiwari

* Created on:- 12th March 2021

* Last Updated by:- Vikas Tiwari

* Last Updated on:- 16th March 2021

* Description:-  make a RestServices Class to access a Rest API.
*/

package com.hrmanager.restapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


import com.hrmanager.entities.Employee;
import com.hrmanager.restapi.RestUrls.ApiConstants;

public class RestServices {

	public static Employee getEmployeeById(int id) {

		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		ResponseEntity<Employee> responseEntity = restTemplate.exchange(ApiConstants.GET_SINGLE_EMPLOYEE + id,
				HttpMethod.GET, null, Employee.class);
		Employee employee = responseEntity.getBody();
		return employee;

	}

	public static List<Employee> getAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		ResponseEntity<Employee[]> response = restTemplate.exchange(ApiConstants.GET_ALL_EMPLOYEE, HttpMethod.GET, null,
				Employee[].class);
		Employee[] employees = response.getBody();
		return Arrays.asList(employees);

	}

	public static void addEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(employee);
		restTemplate.postForLocation(ApiConstants.ADD_EMPLOYEE, requestEntity);

	}

	public static void updateEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(employee);
		restTemplate.put(ApiConstants.UPDATE_EMPLOYEE, requestEntity);

	}

	public static void deleteEmployee(int id) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		restTemplate.delete(ApiConstants.DELETE_EMPLOYEE + id);

	}
}
