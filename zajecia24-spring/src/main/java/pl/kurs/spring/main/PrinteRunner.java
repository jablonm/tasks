package pl.kurs.spring.main;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pl.kurs.spring.bean.PrinterBean;
import pl.kurs.spring.calc.operator.EquationStrategy;

@Service
//@Component
//@Repository
//@Controller
//@Configuration
public class PrinteRunner {

	@Autowired
	private PrinterBean consolePrinter;

	@Autowired
	private PrinterBean anotherTextFilePrinterBean;
	
	@Autowired
	private EquationStrategy equationStrategy;

	public void run() {
		consolePrinter.printText("No teraz to dziala");
		anotherTextFilePrinterBean.printText("do pliku");
		
		Arrays.asList("+","-","*","%","^").forEach(o-> System.out.println(equationStrategy.calculate(new BigDecimal("20"), new BigDecimal("4"), o)));
	}
}
