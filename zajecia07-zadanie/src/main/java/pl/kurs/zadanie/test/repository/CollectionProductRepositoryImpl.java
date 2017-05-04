package pl.kurs.zadanie.test.repository;

import java.util.ArrayList;
import java.util.List;

import pl.kurs.zadanie.test.model.Product;

public class CollectionProductRepositoryImpl implements ProductRepository {

	private List<Product> products = new ArrayList<Product>();
	
	public void saveProduct(Product p) {
		if (!products.contains(p)) {
			products.add(p);
		}
	}

	@Override
	public List<Product> findAllProducts() {
		return products;
	}

}
