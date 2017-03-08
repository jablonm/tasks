package vehicles;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Pojazd pojazd1 = new Pojazd("Mercedes", "Vito", 100);
		Pojazd pojazd2 = new Pojazd("Ford", "Transit", 83);
		Pojazd pojazd3 = new Pojazd("Pegout", "Partner", 98);
		
		pojazd1.dodajNaprawe(new Naprawa("2016-01-12", "Warszawa", new BigDecimal("3452.21"), new BigDecimal("145000")));
		pojazd1.dodajNaprawe(new Naprawa("2016-03-02", "Poznań", new BigDecimal("2452.42"), new BigDecimal("146700")));
		pojazd1.dodajNaprawe(new Naprawa("2016-09-19", "Warszawa", new BigDecimal("3212.97"), new BigDecimal("198700")));
		
		pojazd2.dodajNaprawe(new Naprawa("2016-02-21", "Poznań", new BigDecimal("1122.78"), new BigDecimal("223100")));
		pojazd2.dodajNaprawe(new Naprawa("2017-01-11", "Wrocław", new BigDecimal("1999.23"), new BigDecimal("229921")));
		pojazd2.dodajNaprawe(new Naprawa("2017-03-09", "Kraków", new BigDecimal("2344.75"), new BigDecimal("245601")));
		
		pojazd3.dodajNaprawe(new Naprawa("2016-12-02", "Kraków", new BigDecimal("5666.13"), new BigDecimal("322987")));
		pojazd3.dodajNaprawe(new Naprawa("2017-01-30", "Poznań", new BigDecimal("2441.73"), new BigDecimal("332987")));
		pojazd3.dodajNaprawe(new Naprawa("2017-02-02", "Warszawa", new BigDecimal("8732.23"), new BigDecimal("356400")));
		pojazd3.dodajNaprawe(new Naprawa("2017-02-12", "Warszawa", new BigDecimal("6322.63"), new BigDecimal("357888")));
		
		ArrayList<Pojazd> listaPojazdow = new ArrayList<>();
		listaPojazdow.add(pojazd1);
		listaPojazdow.add(pojazd2);
		listaPojazdow.add(pojazd3);
		
		Pojazd pojazdNajwiecejNapraw = listaPojazdow.stream()//
				.max((p1,p2)->p1.getListaNapraw().size()-p2.getListaNapraw().size()).get();
		
		System.out.println("Najwięcej napraw miał: " + pojazdNajwiecejNapraw);
	}

}
