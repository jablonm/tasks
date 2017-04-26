package pl.kurs.zadanie.test.service;

import java.util.List;
import java.util.Optional;

import pl.kurs.zadanie.test.model.Product;

public interface ProductService {

	Product findMostExpensiveProduct();

	Optional<Product> findMostExpensiveProductByCategory(String category);

	void saveProduct(Product p);

	List<Product> findAllProducts();

}
