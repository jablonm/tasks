package pl.kurs.zadanie.test.service;

import java.util.List;
import java.util.Optional;

import pl.kurs.zadanie.test.model.Product;

public class ProducServiceCacheProxy implements ProductService {
	
	private final ProductService proxyObject;
	private boolean stateChanged;
	
	public ProducServiceCacheProxy(ProductService proxyObject) {
		this.proxyObject = proxyObject;
		this.stateChanged=true;
	}

	public Product findMostExpensiveProduct() {
		return null;
	}

	@Override
	public Optional<Product> findMostExpensiveProductByCategory(String category) {
		return null;
	}

	@Override
	public void saveProduct(Product p) {
		this.stateChanged=true;
		proxyObject.saveProduct(p);
	}

	@Override
	public List<Product> findAllProducts() {
		if(stateChanged){
			stateChanged=false;
			return proxyObject.findAllProducts();
		}
		//pobierz z cache
		return null;
	}

}
