package pl.kurs.spring.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.kurs.spring.crud.model.Dog;
import pl.kurs.spring.crud.service.DogService;

@Controller
@RequestMapping("/dogs")
public class DogController {

	@Autowired
	private DogService dogService;
	
	private String lastSort = "";

	@PostMapping("/create")
	public String create(@ModelAttribute("dogForm") @Valid Dog dog, BindingResult validationResult, ModelMap model) {
		if (!validationResult.hasErrors()) {
			dogService.save(dog);
			model.addAttribute("dogForm", new Dog());
		}

		model.addAttribute("dogs", dogService.getAllDogs("id"));
		return "dogs";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute Dog dog, ModelMap model) {
		if (id != dog.getId()) {
			//rzut wyjatkiem
		}
		dogService.update(dog);
		return enter("id", model);
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute Dog dog, ModelMap model) {
		dogService.removeDog(dog);
		return enter("id", model);
	}

	@GetMapping("/")
	public String enter(@RequestParam(value = "orderBy", defaultValue = "id") String orderBy, ModelMap model) {
		if (lastSort.equals(orderBy)) {
			model.addAttribute("dogs", dogService.getAllDogs(orderBy));
			lastSort = orderBy;
		} else {
			model.addAttribute("dogs", dogService.getAllDogs(orderBy));
			lastSort = orderBy;
		}
		model.addAttribute("dogForm", new Dog());
		return "/dogs";
	}

}
