package pl.kurs.spring.pesel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/start")
public class StartController {

	@GetMapping("/")
	public String start(@RequestParam(required = false, defaultValue = "Nie podano", value = "imie") String imie, ModelMap model) {
		model.addAttribute("userName", imie);
		return "index";
	}

}
