package pl.kurs.spring.products.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kurs.spring.products.model.Product;
import pl.kurs.spring.products.model.ProductCategory;

@Controller
@RequestMapping("/products")
public class ProductController {

	private List<Product> products = new ArrayList<>();

	//DTO RequetDTO, ResponseDTO -> mapowanie obiekt X -> obiekt Y
	//ProductRequestDto -> Product (dodac go do bazy) -> jako wynik zwrocic List<ProductResponseDTO> = mapowanie kazdego produkty pobranego z bazy na produktReponseDto

//	public ProductController() {
//		products.add(new Product("Fasola", new BigDecimal(5), ProductCategory.WARZYWA));
//		products.add(new Product("Piwo", new BigDecimal(3), ProductCategory.NAPOJ));
//		products.add(new Product("Pomidor", new BigDecimal(1), ProductCategory.WARZYWA));
//	}
	
	@PostConstruct
	public void init(){
		
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute Product product, ModelMap model) {
		products.add(product);

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
		model.addAttribute("products", products);
		model.addAttribute("categories", ProductCategory.values());
		return "products";
	}
	
}
