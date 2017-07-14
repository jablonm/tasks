package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String city;

	
	//fetch=FetchType.EAGER - BAN! to zawsze powoduje n+1
	@OneToMany(mappedBy = "client", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch=FetchType.LAZY)
	private Set<Product> products = new HashSet<>();

	public Client() {
	}

	public Client(String name, String city) {
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", city=" + city +"]";
	}

	public void addProduct(Product product) {
		products.add(product);
		product.setClient(this);
	}
	
}
