package az.maqa.spring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import az.maqa.spring.entity.Employee;
import az.maqa.spring.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;

@Configuration
@EnableScheduling
@Log4j2
@EnableAsync
public class SchedulingConfig {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Async
//	@Scheduled(fixedRate = 1000 , initialDelay = 3000)
//	@Scheduled(fixedRate = 1000)
	@Scheduled(cron = "0 * 11 * * ?")
	public void scheduleFixedDelayTask() {
		log.info(System.currentTimeMillis() / 1000);
	}

	/*
	 * @Scheduled(cron = "0 * * * * ?") private void addEmployeeInEveryMinutes() {
	 * Employee employee = new Employee(); employee.setName("Samir");
	 * employee.setSurname("Samirov"); employee.setJob("Welder");
	 * employee.setActive(1);
	 * 
	 * employeeRepository.save(employee);
	 * 
	 * log.info("Employee:" + employee); }
	 */

	@Scheduled(fixedDelay = 1000)
	private void addEmployeeInEverySecond() {
		Employee employee = new Employee();
		employee.setName("Samir");
		employee.setSurname("Samirov");
		employee.setJob("Welder");
		employee.setActive(1);

		employeeRepository.save(employee);

		log.info("Employee:" + employee);
	}

//	@Scheduled(cron = "0 * * * * ?")
//	private void deleteAllEmployeesAfter1Minutes() {
//		List<Employee> employees = employeeRepository.findAllByActive(1);
//
//		for (Employee employee : employees) {
//			employeeRepository.delete(employee);
//			log.info("Employee Deleted...");
//		}
//
//	}
	
	@Scheduled(cron = "0 * * * * ?")
	private void updateAllEmployeesAfter1Minutes() {
		List<Employee> employees = employeeRepository.findAllByActive(1);

		for (Employee employee : employees) {
			employee.setName("Qasim");
			employee.setId(employee.getId());
			employeeRepository.save(employee);
			log.info("Employee Updated... {} " , employee);
		}

	}
	

}
