package pl.kurs.zadanie.test.service;

import java.util.List;
import java.util.Optional;

import pl.kurs.zadanie.test.model.Product;
import pl.kurs.zadanie.test.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	ProductRepository repo;
	
	public Product findMostExpensiveProduct() {
		return this.findAllProducts().stream()//
				.max((p1,p2) -> p1.getPrice().compareTo(p2.getPrice())).get();
	}

	public Optional<Product> findMostExpensiveProductByCategory(String category) {
		return this.findAllProducts().stream().filter(p->p.getCategory().equals(category))//
						.max((p1,p2) -> p1.getPrice().compareTo(p2.getPrice()));
	}

	public void saveProduct(Product p) {
		repo.saveProduct(p);
	}

	public List<Product> findAllProducts() {
		return repo.findAllProducts();
	}

	public ProductServiceImpl(ProductRepository repo) {
		this.repo = repo;
	}

}
