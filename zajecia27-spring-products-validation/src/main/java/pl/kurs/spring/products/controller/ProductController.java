package pl.kurs.spring.products.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kurs.spring.products.model.Product;
import pl.kurs.spring.products.model.ProductCategory;

@Controller
//@Validated
@RequestMapping("/products")
public class ProductController {

	private List<Product> products;

	@PostConstruct
	public void init() {
		products = new ArrayList<>();
		products.add(new Product("Fasola", 5, ProductCategory.WARZYWA));
		products.add(new Product("Piwo", 3, ProductCategory.NAPOJ));
		products.add(new Product("Pomidor", 1, ProductCategory.WARZYWA));
	}

	@PostMapping("/addProduct")
	public String addProduct(@Valid @ModelAttribute("productForm") Product product, BindingResult validationResult, ModelMap model) {

		if (!validationResult.hasErrors()) {
			products.add(product);
			model.addAttribute("productForm", new Product());
		} else {
			model.addAttribute("productForm", product);
		}

		model.addAttribute("products", products);
		model.addAttribute("categories", ProductCategory.values());
		return "products";
	}

	@PostMapping("/deleteProduct")
	public String deleteProduct(@ModelAttribute Product product, ModelMap model) {
		for (Product deleteProduct : products) {
			if (deleteProduct.getId() == product.getId()) {
				product = deleteProduct;
			}
		}

		if (products.contains(product)) {
			products.remove(product);
		}

		model.addAttribute("products", products);
		model.addAttribute("productForm", new Product());
		model.addAttribute("categories", ProductCategory.values());
		return "products";
	}

	@PostMapping("/editProduct/{id}")
	public String editProduct(@PathVariable int id, @ModelAttribute Product product) {
		for (Product deleteProduct : products) {
			if (deleteProduct.getId() == product.getId()) {
				product = deleteProduct;
			}
		}
		return "products";
	}

	@GetMapping("/")
	public String enter(ModelMap model) {

		model.addAttribute("productForm", new Product());
		model.addAttribute("products", products);
		model.addAttribute("categories", ProductCategory.values());
		return "products";
	}

}
