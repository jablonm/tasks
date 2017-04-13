package pl.kurs.test.service;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import pl.kurs.test.model.Employee;
import pl.kurs.test.repository.EmployeeRepository;

public class EmployeeServiceTest {
	
	private EmployeeRepository employeeRepository;
	private EmployeeService employeeService;

	@Before
	public void init() {
		this.employeeRepository = new EmployeeRepository();
		Employee e1 = new Employee("Andrzej1", "Kowalski1", 10500, "manager");
		Employee e2 = new Employee("Andrzej2", "Kowalski2", 8500, "developer");
		Employee e3 = new Employee("Andrzej3", "Kowalski3", 5500, "analyst");
		Employee e4 = new Employee("Andrzej3", "Kowalski4", 6000, "analyst");
		Employee e5 = new Employee("Andrzej3", "Kowalski5", 7000, "developer");
		Employee e6 = new Employee("Andrzej3", "Kowalski6", 8000, "pm");
		Arrays.asList(e1,e2,e3,e4,e5,e6).forEach(employeeRepository::save);
		this.employeeService = new EmployeeService(employeeRepository);
	}
	
	@Test
	public void findBestSalaryTest() {
		Employee result = employeeService.findBestSalary();
		Assert.assertEquals("Andrzej1", result.getName());
		Assert.assertEquals("Kowalski1", result.getSurname());
		Assert.assertEquals(10500, result.getSalary(), 0.001);
		Assert.assertEquals("manager", result.getPosition());
	}

}
