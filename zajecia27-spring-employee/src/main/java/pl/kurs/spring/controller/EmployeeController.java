package pl.kurs.spring.controller;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kurs.spring.model.Department;
import pl.kurs.spring.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private Map<Integer, Employee> employees;

	@PostConstruct
	public void init() {
		employees = new TreeMap<>();
		Employee newEmployee = new Employee("Arkadiusz Gabka", "Kierownik", 4500.90, "92321224432", "Polska", Department.HR);
		employees.put(newEmployee.getId(), newEmployee);
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Employee employee, ModelMap model) {
		Employee newEmployee = new Employee(employee.getName(), employee.getPosition(), employee.getSalary(), employee.getPesel(), employee.getAddress(), employee.getDepartment());
		employees.put(newEmployee.getId(), newEmployee);

		model.addAttribute("employees", employees.values());
		model.addAttribute("departments", Department.values());
		return "employee";
	}
	
	@GetMapping("/")
	public String enter(ModelMap model) {

		model.addAttribute("employees", employees.values());
		model.addAttribute("departments", Department.values());
		return "employee";
	}

}
