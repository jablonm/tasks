package pl.kurs.painter.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kurs.painter.config.PainterConfiguration;
import pl.kurs.spring.painter.painter.Painter;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PainterConfiguration.class);
		Painter square = context.getBean("squarePrinter", Painter.class);
		//square.print(10);
		Painter square10 = context.getBean("squarePainterDeafult", Painter.class);
		square10.print();
		context.close();
	}
}
