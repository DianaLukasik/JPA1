package com.capgemini.service;

import org.springframework.stereotype.Service;

import com.capgemini.domain.EmployeeEntity;

@Service
public interface EmployeeService {
 
EmployeeEntity save();
EmployeeEntity delete ();
EmployeeEntity update();


	
}
