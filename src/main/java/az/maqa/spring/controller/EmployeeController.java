package az.maqa.spring.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.maqa.spring.dto.EmployeeDTO;
import az.maqa.spring.response.ResponseEmployee;
import az.maqa.spring.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<ResponseEmployee> findAllEmployees() {
		List<ResponseEmployee> response = new ArrayList<>();

		ModelMapper modelMapper = new ModelMapper();
		
		List<EmployeeDTO> employees = employeeService.getAllEmployees();

		Type listType = new TypeToken<List<ResponseEmployee>>() {
		}.getType();
		response = modelMapper.map(employees, listType);

		return response;
	}

}
