package az.maqa.spring.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.maqa.spring.dto.EmployeeDTO;
import az.maqa.spring.entity.Employee;
import az.maqa.spring.repository.EmployeeRepository;
import az.maqa.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAllByActive(1);

		ModelMapper modelMapper = new ModelMapper();

		Type listType = new TypeToken<List<EmployeeDTO>>() {
		}.getType();

		List<EmployeeDTO> returnValue = modelMapper.map(employees, listType);

		return returnValue;
	}

}
