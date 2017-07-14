package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Doctor extends Person {
	private String spec;

	@ManyToMany
	@JoinTable(name = "patients_doctors", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = { @JoinColumn(name = "doctor_id") })
	private Set<Patient> patients = new HashSet<>();

	public Doctor() {
	}

	public Doctor(String name, String surname, String spec) {
		super(name, surname);
		this.spec = spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + getName() + ", name=" + getName() + ", surname=" + getSurname() + "]";
	}

	public void addPatient(Patient patient) {
		patients.add(patient);
		patient.getDoctors().add(this);
	}

}
