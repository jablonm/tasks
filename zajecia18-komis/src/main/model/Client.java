package main.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
	private static final AtomicInteger GENERATOR = new AtomicInteger();

	private int id;
	private String name;
	private String secondName;
	private String address;
	private String tel;
	private String city;

	public Client(String name, String secondName, String address, String tel, String city) {
		this.name = name;
		this.secondName = secondName;
		this.address = address;
		this.tel = tel;
		this.city = city;
		this.id = GENERATOR.incrementAndGet();
	}

	public int getId() {
		return id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
