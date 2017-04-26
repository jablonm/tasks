package pl.kurs.zadanie.test.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import pl.kurs.test.model.Employee;
import pl.kurs.zadanie.test.model.Product;
import pl.kurs.zadanie.test.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	ProductRepository repo;
	
	public Product findMostExpensiveProduct() {
		return this.findAllProducts().stream()//
				.max((p1,p2) -> Integer.parseInt(p1.getPrice())-Integer.parseInt(p2.getPrice())).get();
	}

	public Optional<Product> findMostExpensiveProductByCategory(String category) {
		return this.findAllProducts().stream()//
				.collect(Collectors.groupingBy(Product::getCategory, Collectors.maxBy((p1,p2) -> Integer.parseInt(p1.getPrice())-Integer.parseInt(p2.getPrice))));
				//findAll().stream().collect(Collectors.groupingBy(Employee::getPosition, Collectors.averagingDouble(Employee::getSalary)))
	}
//.collect(Collectors.maxBy((p1,p2) -> Integer.parseInt(p1.getPrice())-Integer.parseInt(p2.getPrice()));

	public void saveProduct(Product p) {
		repo.saveProduct(p);
	}

	public List<Product> findAllProducts() {
		return repo.findAllProducts();
	}

}
