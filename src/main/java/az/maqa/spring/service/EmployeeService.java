package az.maqa.spring.service;

import java.util.List;

import az.maqa.spring.dto.EmployeeDTO;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployees();
	
}
