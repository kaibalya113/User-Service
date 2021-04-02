package com.user.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.main.dao.UserDao;
import com.user.main.model.User;
import com.user.main.valueObject.Department;
import com.user.main.valueObject.ResponseTemplate;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		
		return userDao.save(user);
	}

	public ResponseTemplate getUserWithDepartment(Long userId) {
		ResponseTemplate responseTemplate = new ResponseTemplate();
		User user = userDao.findByUserId(userId);
		// we ll call the department 
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		responseTemplate.setUser(user);
		responseTemplate.setDepartment(department);
		return responseTemplate;
	}
	
	
}
