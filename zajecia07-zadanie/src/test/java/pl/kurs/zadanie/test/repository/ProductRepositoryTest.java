package pl.kurs.zadanie.test.repository;

import pl.kurs.zadanie.test.service.ProductService;
import pl.kurs.zadanie.test.service.ProductServiceImpl;

public class ProductRepositoryTest {

	public static void main(String[] args) {
		//ProductRepository repo = new CollectionProductRepositoryImpl();
		ProductRepository repo = new FileProductRepositoryImpl();
		//repo.findAllProducts().forEach(System.out::println);
		ProductService ps = new ProductServiceImpl(repo);
		System.out.println(ps.findMostExpensiveProduct());
		System.out.println(ps.findMostExpensiveProductByCategory("napoje"));
	}
	
}
