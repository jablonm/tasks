package pl.kurs.spring.config;

import java.io.File;
import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pl.kurs.spring.bean.PrinterBean;
import pl.kurs.spring.bean.impl.ConsolePrinterBean;
import pl.kurs.spring.bean.impl.FilePrinterBean;
import pl.kurs.spring.calc.operator.Operator;

@Configuration
@ComponentScan(basePackages = { "pl.kurs.spring" })
public class PrinterApplicationConfiguration {

	@Bean
	public PrinterBean consolePrinter() {
		return new ConsolePrinterBean();
	}

	@Bean
	@Scope("session") //domyslnie nie trzeba pisac
	public PrinterBean textFilePrinterBean() {
		return new FilePrinterBean(new File("test.txt"));
	}

	@Bean
	@Scope("prototype")
	public PrinterBean anotherTextFilePrinterBean() {
		return new FilePrinterBean(new File("logs.txt"));
	}

	@Bean
	public Operator moduloOperator() {
		return new Operator() {

			@Override
			public String key() {
				return "%";
			}

			@Override
			public BigDecimal calculate(BigDecimal d1, BigDecimal d2) {
				return new BigDecimal(d1.doubleValue() % d2.doubleValue());
			}
		};
	}

}
