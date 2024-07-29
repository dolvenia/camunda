package com.practice.services;

import org.springframework.stereotype.Component;

@Component
public class UserDepartmentService {
	
	public String getUserDepartment() {
		
		System.out.println("This is coming from getUserDepartment method of userDepartment Service");
		
		return "Accounts";
	}

}
