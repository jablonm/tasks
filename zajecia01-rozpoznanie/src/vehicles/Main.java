package vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Stwórz prostą relację jeden-do-wiele pomiędzy obiektami Samochód (marka, model, moc) Naprawa(data, miejsca, koszt, przebieg auta)
//Naprawa dotyczy jednego samochodu natomiast samochód może mieć wiele napraw. - wykorzystaj kompozycję obiektów (tzn: naprawa bez samochodu jest bez sensu :) )
// 
//Następnie w mainie stwórz listę 10 napraw dla 3 samochodów i:
//- znajdz samochód z największą liczbą napraw +
//- znajdz samochód którego naprawy kosztowały najwięcej
//- znajdz najdrozsza naprawę
//- policz ile było napraw dla poszczególnych marek samochodów
//- zrób zestawienie marka samochodu -> średni przebieg podczas naprawy

public class Main {

	public static void main(String[] args) {

		Pojazd pojazd1 = new Pojazd("Mercedes", "Vito", 100);
		Pojazd pojazd2 = new Pojazd("Ford", "Transit", 83);
		Pojazd pojazd3 = new Pojazd("Pegout", "Partner", 98);
		
		new Naprawa("2016-01-12", "Warszawa", new Double(3452.21), new Double(145000), pojazd1);
		new Naprawa("2016-03-02", "Poznań", new Double(2452.42), new Double(146700), pojazd1);
		new Naprawa("2016-09-19", "Warszawa", new Double(3212.97), new Double(198700), pojazd1);
		
		new Naprawa("2016-02-21", "Poznań", new Double(1122.78), new Double(223100), pojazd2);
		new Naprawa("2017-01-11", "Wrocław", new Double(1999.23), new Double(229921), pojazd2);
		new Naprawa("2017-03-09", "Kraków", new Double(2344.75), new Double(245601), pojazd2);
		
		new Naprawa("2016-12-02", "Kraków", new Double(5666.13), new Double(322987), pojazd3);
		new Naprawa("2017-01-30", "Poznań", new Double(2441.73), new Double(332987), pojazd3);
		new Naprawa("2017-02-02", "Warszawa", new Double(8732.23), new Double(356400), pojazd3);
		new Naprawa("2017-02-12", "Warszawa", new Double(6322.63), new Double(357888), pojazd3);
	
		ArrayList<Pojazd> listaPojazdow = new ArrayList<>();
		listaPojazdow.add(pojazd1);
		listaPojazdow.add(pojazd2);
		listaPojazdow.add(pojazd3);
		
		Pojazd pojazdNajwiecejNapraw = listaPojazdow.stream()//
				.max((p1,p2)->p1.getListaNapraw().size()-p2.getListaNapraw().size()).get();
		System.out.println(pojazdNajwiecejNapraw);
		
		Pojazd pojazdMaxSumaNaprawy = listaPojazdow.stream().max((p1,p2)->Double.compare(p1.wartoscNapraw(), p2.wartoscNapraw())).get();
		System.out.println(pojazdMaxSumaNaprawy);
		
		Pojazd pojazdZNajdrozszaNaprawa = listaPojazdow.stream()//
				.max((p1,p2)->Double.compare(p1.najdrozszaNaprawa().getKoszt(), p2.najdrozszaNaprawa().getKoszt())).get();
		System.out.println("Najdroższa naprawa: " + pojazdZNajdrozszaNaprawa.najdrozszaNaprawa().getKoszt());
		
		List<Naprawa> listaNapraw = new ArrayList<>();
		listaPojazdow.stream().map(p-> p.getListaNapraw()).forEach(listaNapraw::addAll);
		
		Map<String, Long> ileNapraw = listaNapraw.stream().collect(Collectors.groupingBy(n-> n.getPojazd().getMarka(), Collectors.counting()));
		System.out.println(ileNapraw);
	}

}
