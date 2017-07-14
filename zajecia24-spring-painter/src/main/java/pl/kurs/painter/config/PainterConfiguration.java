package pl.kurs.painter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.kurs.spring.painter.impl.ChristmasTreePainterImpl;
import pl.kurs.spring.painter.impl.SquarePainterDefaultImpl;
import pl.kurs.spring.painter.impl.SquarePainterImpl;
import pl.kurs.spring.painter.painter.Painter;

@Configuration
@ComponentScan(basePackages = {"pl.kurs.printer"})
public class PainterConfiguration {

	@Bean
	public Painter squarePrinter() {
		return new SquarePainterImpl();
	}

	@Bean
	public Painter christmasTreePrinter() {
		return new ChristmasTreePainterImpl();
	}

	@Bean
	public Painter squarePainterDeafult() {
		return new SquarePainterDefaultImpl();
	}
	
}