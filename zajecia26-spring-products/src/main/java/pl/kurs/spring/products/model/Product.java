package pl.kurs.spring.products.model;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
	private static final AtomicInteger GENERATOR = new AtomicInteger();
	private String name;
	private BigDecimal price;
	private ProductCategory category;
	private int id;

	public Product() {
	}

	public Product(String name, BigDecimal price, ProductCategory category) {
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}
