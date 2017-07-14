package pl.kurs.spring.products.model;

import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	private static final AtomicInteger GENERATOR = new AtomicInteger();

	//chce aby nazwa produktu zaczynala sie z wielkiej litery
	@NotEmpty(message = "Nazwa produktu nie moze byc pusta")
	@Pattern(regexp="^([A-Z])(.*)", message = "Nazwa produktu musi zaczynac sie z wielkiej litery")
	private String name;
	@Min(value = 0, message = "Cena nie moze byc mniejsza 0")
	private long price;
	//@NotEmpty(message = "Kategoria nie moze byc pusta")
	private ProductCategory category;
	private int id;

	public Product() {
	}

	public Product(String name, long price, ProductCategory category) {
		this.id = GENERATOR.incrementAndGet();
		this.name = name;
		this.price = price;
		this.category = category;
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}
