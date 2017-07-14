package pl.kurs.spring.pesel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kurs.spring.pesel.command.PeselCommand;

@Controller
@RequestMapping("/pesel")
public class PeselController {

	private PeselCommand pesel;

//	@GetMapping("/execute")
//	public String calc(@ModelAttribute CalculationCommand command, ModelMap model) {
//		BigDecimal result = strategy.calculate(command.getL1(), command.getL2(), command.getOperator());
//		model.addAttribute("result", result);
//		model.addAttribute("operators", );
//		history.add(new CalcHistoryDTO(command.getL1(), command.getL2(), command.getOperator(), new Date().toLocaleString()));
//		return "calc";
//	}

	@GetMapping("/execute")
	public String pesel(@ModelAttribute PeselCommand pesel, ModelMap model) {
		model.addAttribute("pesel", pesel);
		return "validatePesel";
	}
	
	@GetMapping("/")
	public String enter(ModelMap model) {
		model.addAttribute("pesel", pesel);
		return "pesel";
	}

}
