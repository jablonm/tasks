package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String secondName;

	@OneToMany(mappedBy = "driver", cascade = { CascadeType.MERGE, CascadeType.PERSIST } )
	private Set<Vehicle> vehicles = new HashSet<>();

	public Driver() {
	}

	public Driver(String name, String secondName) {
		this.name = name;
		this.secondName = secondName;
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

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void addVehicle(Vehicle v) {
		vehicles.add(v);
		v.setDriver(this);
	}
	
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", secondName=" + secondName + "]";
	}
	

}
