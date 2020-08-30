package az.maqa.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import az.maqa.spring.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findAllByActive(Integer active);

}
