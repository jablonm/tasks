package main;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import main.model.Client;
import main.model.Product;

public class Main {

	public static void main(String[] args) {
		HibernateUtil connection = HibernateUtil.instance();
		Session sesja = connection.openTransaction();

		Product newProduct1 = new Product("Kolo", new BigDecimal(1000), "Samochod");
		Product newProduct2 = new Product("Zelazko", new BigDecimal(500), "AGD");
		Product newProduct3 = new Product("Klawiatura", new BigDecimal(100), "Komputer");
		Product newProduct4 = new Product("Odkurzacz", new BigDecimal(1500), "AGD");
		Product newProduct5 = new Product("Telewizor", new BigDecimal(4000), "RTV");

		System.out.println("Przed zapisem: " + newProduct1);
		newProduct1 = (Product) sesja.merge(newProduct1);
		newProduct2 = (Product) sesja.merge(newProduct2);
		newProduct3 = (Product) sesja.merge(newProduct3);
		newProduct4 = (Product) sesja.merge(newProduct4);
		newProduct5 = (Product) sesja.merge(newProduct5);
		//PO MERGEU newProduct1 staje sie obiektem ZARZADZANYM
		//tzn: ze dopoki sesja jest OTWARTA kazda zmiana na tym obiekcie bedzie odwzorowana w bazie danych
		System.out.println("Po zapisie: " + newProduct1);

		//DirtyChecking
		newProduct1.setPrice(new BigDecimal(1200));

		//w momencie commita sesji hibernate analizuje caly L1 cache dla danej sesji.

		connection.commitTransaction(sesja);

		sesja = connection.openTransaction();
		List<Product> allProducts = sesja.createCriteria(Product.class).add(Restrictions.eq("category", "AGD")).list();
		allProducts.forEach(System.out::println);
		List<Product> allProducts2 = sesja.createQuery("select p from Product p where p.category = :category").setParameter("category", "AGD").list();
		System.out.println("AGD:" + allProducts2);
		connection.commitTransaction(sesja);

		sesja = connection.openTransaction();

		Product id1 = (Product) sesja.get(Product.class, 1);
		System.out.println("id1: " + id1);
		id1 = (Product) sesja.get(Product.class, 1);
		System.out.println("jeszcze raz: " + id1);
		connection.commitTransaction(sesja);
		
		
		//stworz klienta, dodaj do niego 2-3 produkty i zapisz klienta.
		sesja = connection.openTransaction();
		Client newClient = new Client("Adam", "Warszawa");
		newClient.addProduct(new Product("Lampa", new BigDecimal(100), "Oswietlenie"));
		newClient.addProduct(new Product("Rower", new BigDecimal(2000), "Rowery"));
		newClient = (Client) sesja.merge(newClient);
		connection.commitTransaction(sesja);
		
	}

}
