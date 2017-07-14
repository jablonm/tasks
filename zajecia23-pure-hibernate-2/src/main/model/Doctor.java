package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Doctor extends Person {
	private String spec;

	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.ALL })
	private Set<Visit> visits = new HashSet<>();
	
	public Doctor() {
	}

	public Doctor(String name, String surname, String spec) {
		super(name, surname);
		this.spec = spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + getName() + ", name=" + getName() + ", surname=" + getSurname() + ", spec=" + spec + "]";
	}

	public void addVisit(Visit visit) {
		visits.add(visit);
		visit.setDoctor(this);
	}
	
}
