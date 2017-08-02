package pl.kurs.spring.aop.printer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.kurs.spring.aop.printer.impl.ConsolePrinter;
import pl.kurs.spring.aop.printer.impl.FilePrinter;
import pl.kurs.spring.aop.printer.impl.PrinterBean;

@Configuration
@ComponentScan(basePackages = "pl.kurs.spring.aop.printer")
@EnableAspectJAutoProxy
public class PrinterConfiguration {

	@Bean
	public PrinterBean testFilePrinter() {
		return new FilePrinter("test.txt");
	}

	@Bean
	public PrinterBean prodFilePrinter() {
		return new FilePrinter("prod.txt");
	}

	public PrinterBean consolePrinter() {
		return new ConsolePrinter();
	}
	
}
