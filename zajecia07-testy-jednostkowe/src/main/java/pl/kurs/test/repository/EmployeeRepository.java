package pl.kurs.test.repository;

import java.util.ArrayList;
import java.util.List;

import pl.kurs.test.model.Employee;

public class EmployeeRepository {
	private List<Employee> data;

	public EmployeeRepository() {
		data = new ArrayList<Employee>();
	}

	public void save(Employee emp) {
		if (!data.contains(emp)) {
			data.add(emp);
		}
	}

	public void remove(Employee emp) {
		if (data.contains(emp)) {
			data.remove(emp);
		}
	}

	public Employee findOne(int id) {
		return data.stream().filter(e -> e.getId() == id).findAny().orElseThrow(IllegalArgumentException::new);
	}

	public List<Employee> findAll() {
		return data;
	}

}
