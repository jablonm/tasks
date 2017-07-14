package main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Visit {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private Date visitDate;

	@ManyToOne()
	@JoinColumn(name = "patientId")
	private Patient patient;

	@ManyToOne()
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	public Visit() {
	}

	public Visit(Date visitDate, Patient patien, Doctor doctor) {
		this.visitDate = visitDate;
		addVisit(doctor, patien);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void addVisit(Doctor doctor, Patient patient) {
		this.patient = patient;
		this.doctor = doctor;
		patient.addVisit(this);
		doctor.addVisit(this);
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", visitDate=" + visitDate + ", patien=" + patient + ", doctor=" + doctor + "]";
	}

}
