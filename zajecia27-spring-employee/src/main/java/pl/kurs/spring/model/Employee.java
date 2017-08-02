package pl.kurs.spring.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {

	private static final AtomicInteger GENERATOR = new AtomicInteger();
    private int id;
	
	private String name;
	private String position;
	private double salary;
	private String pesel;
	private String address;
	private Department department;

	public Employee() {
	}

	public Employee(String name, String position, double salary, String pesel, String address, Department department) {
		this.id = GENERATOR.incrementAndGet();
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.pesel = pesel;
		this.address = address;
		this.department = department;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}