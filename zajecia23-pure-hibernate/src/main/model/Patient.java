package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Patient extends Person {
	private int age;
	private String disease;

	@ManyToMany(mappedBy = "patients")
	private Set<Doctor> doctors = new HashSet<>();

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

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
		doctor.getPatients().add(this);
	}

	@Override
	public String toString() {
		return "Patient [id=" + getId() + ", name=" + getName() + ", surname=" + getSurname() + ", age=" + age + ", disease=" + disease + "]";
	}

}
