package pl.kurs.test.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pl.kurs.test.model.Employee;
import pl.kurs.test.repository.EmployeeRepository;

public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee findBestSalary() {
		return employeeRepository.findAll().stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
	}

	public List<Employee> findByPosition(String position) {
		return employeeRepository.findAll().stream().filter(e -> e.getPosition().equals(position)).collect(Collectors.toList());
	}

	public double avgSalary() {
		return employeeRepository.findAll().stream().collect(Collectors.averagingDouble(Employee::getSalary));
	}

	public double avgSalaryForPosition(String position) {
		return employeeRepository.findAll().stream().filter(e -> e.getPosition().equals(position)).collect(Collectors.averagingDouble(Employee::getSalary));
	}

	public Map<String, Double> avgSalaryForEachPosition() {
		return employeeRepository.findAll().stream().collect(Collectors.groupingBy(Employee::getPosition, Collectors.averagingDouble(Employee::getSalary)));
	}

}
