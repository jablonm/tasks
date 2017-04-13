package pl.kurs.test.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.kurs.test.model.Employee;
import pl.kurs.test.repository.EmployeeRepository;

public class EmployeeRepositoryTest {

	private EmployeeRepository employeeRepository;

	@Before
	public void init() {
		this.employeeRepository = new EmployeeRepository();
	}

	@Test
	public void saveTest() {
		//given
		Employee e1 = new Employee("Andrzej", "Kowalski", 2500, "manager");

		//when
		employeeRepository.save(e1);

		//then
		Employee result = employeeRepository.findOne(e1.getId());
		Assert.assertEquals(e1, result);
	}

	@Test
	public void findOneTest() {
		Employee expected = new Employee("Andrzej", "Kowalski", 2500, "manager");
		employeeRepository.save(expected);
		Employee result = employeeRepository.findOne(expected.getId());
		Assert.assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findOneTest_2() {
		Employee expected = new Employee("Andrzej", "Kowalski", 2500, "manager");
		employeeRepository.save(expected);
		Employee result = employeeRepository.findOne(5);
		Assert.assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeTest() {
		Employee expected = new Employee("Andrzej", "Kowalski", 2500, "manager");
		employeeRepository.save(expected);
		employeeRepository.remove(expected);
		Employee result = employeeRepository.findOne(expected.getId());
		Assert.assertEquals(expected, result);
	}

	@Test
	public void findAllTest() {
		Employee e1 = new Employee("Andrzej1", "Kowalski", 2500, "manager");
		Employee e2 = new Employee("Andrzej2", "Kowalski", 2500, "developer");
		Employee e3 = new Employee("Andrzej3", "Kowalski", 2500, "analyst");
		List<Employee> source = Arrays.asList(e1,e2,e3).stream().collect(Collectors.toList());
		source.forEach(employeeRepository::save);
		
		List<Employee> result = employeeRepository.findAll();
		
		Assert.assertEquals(source, result);
	}
	
}
