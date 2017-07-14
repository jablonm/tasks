package pl.kurs.spring.mvc.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kurs.spring.calc.operator.EquationStrategy;
import pl.kurs.spring.calc.operator.Operator;
import pl.kurs.spring.mvc.command.CalculationCommand;
import pl.kurs.spring.mvc.dto.CalcHistoryDTO;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

	private final EquationStrategy strategy;
	private final List<String> operators;
	private List<CalcHistoryDTO> history = new ArrayList<>();

	@Autowired
	public CalculatorController(EquationStrategy strategy, Set<Operator> operators) {
		this.strategy = strategy;
		this.operators = Collections.unmodifiableList(operators.stream().map(Operator::key).collect(Collectors.toList()));
	}

	@GetMapping("/execute")
	public String calc(@ModelAttribute CalculationCommand command, ModelMap model) {
		BigDecimal result = strategy.calculate(command.getL1(), command.getL2(), command.getOperator());
		model.addAttribute("result", result);
		model.addAttribute("operators", operators);
		history.add(new CalcHistoryDTO(command.getL1(), command.getL2(), command.getOperator(), new Date().toLocaleString()));
		return "calc";
	}

	@GetMapping("/history")
	public String history(ModelMap model) {
		model.addAttribute("history", history);
		return "calcHistory";
	}
	
	@GetMapping("/")
	public String enter(ModelMap model) {
		model.addAttribute("operators", operators);
		return "calc";
	}

}
