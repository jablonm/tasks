package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Patient extends Person {
	private int age;
	private String disease;

	@OneToMany(mappedBy="patient", cascade = {CascadeType.ALL})
	private Set<Visit> visits = new HashSet<>();
	
	public Patient() {
	}

	public Patient(String name, String surname, int age, String disease) {
		super(name, surname);
		this.age = age;
		this.disease = disease;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public void addVisit(Visit visit) {
		visits.add(visit);
		visit.setPatient(this);
	}

	@Override
	public String toString() {
		return "Patient [id=" + getId() + ", name=" + getName() + ", surname=" + getSurname() + ", age=" + age + ", disease=" + disease + "]";
	}

}
