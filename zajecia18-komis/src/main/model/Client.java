package main.model;

public class Client implements Comparable<Client> {
	private int id;
	private String name;
	private String secondName;
	private String address;
	private String city;
	private int tel;

	public Client(int id, String name, String secondName, String address, String city, int tel) {
		this.id = id;
		this.name = name;
		this.secondName = secondName;
		this.address = address;
		this.city = city;
		this.tel = tel;
	}

	public Client(String name, String secondName, String address, String city, int tel) {
		this.name = name;
		this.secondName = secondName;
		this.address = address;
		this.city = city;
		this.tel = tel;
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

	public void setName(String name) throws Exception {
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int compareTo(Client o) {
		return this.compareTo(o);
	}

}
