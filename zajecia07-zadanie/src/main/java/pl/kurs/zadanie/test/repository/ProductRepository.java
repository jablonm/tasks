package pl.kurs.zadanie.test.repository;

import java.util.List;

import pl.kurs.zadanie.test.model.Product;

public interface ProductRepository {

	void saveProduct(Product p);

	List<Product> findAllProducts();

}
