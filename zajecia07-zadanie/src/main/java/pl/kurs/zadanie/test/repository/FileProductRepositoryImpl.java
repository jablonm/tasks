package pl.kurs.zadanie.test.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import pl.kurs.zadanie.test.model.Product;

public class FileProductRepositoryImpl implements ProductRepository {
	
	private List<Product> products = new ArrayList<Product>();
	
	public void saveProduct(Product p) {
		if (!products.contains(p)) {
			products.add(p);
		}
	}

	public List<Product> findAllProducts() {
		
		try (BufferedReader in = new BufferedReader(new FileReader("products.txt"))) {
			String line = null;
			while ((line = in.readLine()) != null) {
				String[] words = line.split(";");
				Product product = new Product(words[0], words[1], words[2], words[3]);
				if (!products.contains(product)) {
					this.saveProduct(product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}

}