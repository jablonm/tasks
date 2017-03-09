import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Patient p1 = new Patient("Jan", "Kowalski", 30, "Krakow");
		Patient p2 = new Patient("Anna", "Kowalska", 32, "Krakow");
		Patient p3 = new Patient("Marek", "Szczepanski", 28, "Warszawa");
		Patient p4 = new Patient("Sylwia", "Piekarska", 40, "Krakow");
		Patient p5 = new Patient("Katarzyna", "Nowak", 56, "Warszawa");
		Patient p6 = new Patient("Franek", "Jozef", 25, "Warszawa");
		Patient p7 = new Patient("Bartek", "Marczak", 31, "Królestwo Konstaincina");

		MedicalDoctor md1 = new MedicalDoctor("Genowefa", "Sercowa", 60, "Warszawa", "Kardiologia");
		MedicalDoctor md2 = new MedicalDoctor("Stefan", "Cipny", 55, "Krakow", "Ginekologia");
		MedicalDoctor md3 = new MedicalDoctor("Zenon", "Umierający", 45, "Warszawa", "Patologia");
		MedicalDoctor md4 = new MedicalDoctor("Mirosław", "Psycho", 30, "Krakow", "Psychiatria");
		MedicalDoctor md5 = new MedicalDoctor("Angelika", "Lubiloda", 25, "Królestwo Konstaincina", "Kardiologia");
		MedicalDoctor md6 = new MedicalDoctor("Judyna", "Jupiter", 45, "Warszawa", "Kardiologia");
		MedicalDoctor md7 = new MedicalDoctor("Kazimierz", "Jupiter", 50, "Krakow", "Psychiatria");
		MedicalDoctor md8 = new MedicalDoctor("Rudolf", "Jupiter", 29, "Warszawa", "Kardiologia");
		MedicalDoctor md9 = new MedicalDoctor("Marlena", "Jupiter", 32, "Warszawa", "Ortopeda");

		List<Visit> visits = Arrays.asList(//
				new Visit(p1, md1, data(2017, 06, 01, 13, 00), "Kontrola"), //
				new Visit(p2, md1, data(2017, 05, 02, 13, 00), "Kontrola"), //
				new Visit(p3, md1, data(2017, 04, 03, 13, 00), "Kontrola"), //
				new Visit(p4, md1, data(2017, 03, 04, 13, 00), "Kontrola"), //
				new Visit(p5, md1, data(2017, 02, 05, 13, 00), "Kontrola"), //
				new Visit(p6, md1, data(2017, 06, 06, 13, 00), "Kontrola"), //
				new Visit(p7, md1, data(2017, 06, 07, 13, 00), "Kontrola"), //
				new Visit(p1, md2, data(2017, 06, 8, 13, 00), "Kontrola"), //
				new Visit(p2, md1, data(2017, 06, 9, 13, 00), "Kontrola"), //
				new Visit(p2, md2, data(2017, 04, 1, 13, 00), "Kontrola"), //
				new Visit(p3, md2, data(2017, 12, 2, 13, 00), "Kontrola"), //
				new Visit(p3, md2, data(2017, 12, 1, 13, 00), "Kontrola"), //
				new Visit(p3, md2, data(2017, 12, 1, 13, 00), "Kontrola"), //
				new Visit(p4, md3, data(2017, 12, 1, 13, 00), "Kontrola"), //
				new Visit(p4, md3, data(2017, 11, 1, 13, 00), "Kontrola"), //
				new Visit(p5, md3, data(2017, 10, 11, 13, 00), "Kontrola"), //
				new Visit(p5, md3, data(2017, 06, 21, 13, 00), "Kontrola"), //
				new Visit(p6, md3, data(2017, 06, 21, 13, 00), "Kontrola"), //
				new Visit(p7, md4, data(2017, 06, 21, 13, 00), "Kontrola"), //
				new Visit(p7, md5, data(2017, 06, 11, 13, 00), "Kontrola"), //
				new Visit(p1, md4, data(2017, 10, 11, 13, 00), "Kontrola"), //
				new Visit(p2, md5, data(2017, 07, 21, 13, 00), "Kontrola"), //
				new Visit(p3, md4, data(2017, 02, 11, 13, 00), "Kontrola"), //
				new Visit(p6, md5, data(2017, 03, 11, 13, 00), "Kontrola"), //
				new Visit(p7, md4, data(2017, 04, 21, 13, 00), "Kontrola"), //
				new Visit(p4, md6, data(2017, 8, 01, 13, 00), "Kontrola"), //
				new Visit(p3, md6, data(2017, 06, 01, 13, 00), "Kontrola"), //
				new Visit(p3, md6, data(2017, 06, 01, 14, 00), "Kontrola"), //
				new Visit(p2, md7, data(2017, 06, 01, 15, 00), "Kontrola"), //
				new Visit(p3, md7, data(2017, 06, 01, 16, 00), "Kontrola"), //
				new Visit(p1, md8, data(2017, 06, 01, 17, 00), "Kontrola"), //
				new Visit(p7, md8, data(2017, 06, 01, 18, 00), "Kontrola"), //
				new Visit(p6, md9, data(2017, 06, 01, 19, 00), "Kontrola"), //
				new Visit(p5, md9, data(2017, 06, 01, 13, 00), "Kontrola")//
		);//

		// Pacjent z najwieksza liczba wizyt (Marek Szczepanski - 8 wizyt)
		Patient maxVisits = visits.stream().map(Visit::getPatient).distinct().max((a1,a2)->a1.getVisits().size()-a2.getVisits().size()).get();
		System.out.println(maxVisits);
		
		// Lekarz z najwieksza liczba wizyt: (Genowefa Sercowa - 8 wizyt)
		MedicalDoctor maxVisitsMd = visits.stream().map(Visit::getDoctor).distinct().max((b1,b2)->b1.getVisits().size()-b2.getVisits().size()).get();
		System.out.println(maxVisitsMd);
		
		// zestawienie: specjalizacja -> ilosc pacjentow
		// Ortopeda-> 2
		// Patologia-> 5
		// Ginekologia-> 5
		// Psychiatria-> 6
		// Kardiologia-> 16
		Map<String, Long> zestawienieSpecjalizacjaIloscPacjentow = visits.stream().collect(Collectors.groupingBy(p->p.getDoctor().getSpecialization(), Collectors.counting()));
		System.out.println(zestawienieSpecjalizacjaIloscPacjentow);

		// zestawienie: miasto -> liczba pacjentow
		// Warszawa-> 3
		// Krakow-> 3
		// Królestwo Konstaincina-> 1
		Map<String, Long> zestawienieMiastoLiczbaPacjetnow = visits.stream().map(Visit::getPatient).distinct().collect(Collectors.groupingBy(Patient::getCity, Collectors.counting()));
		System.out.println(zestawienieMiastoLiczbaPacjetnow);

		// zestawienie: miasto -> sredni wiek pacjenta w danym miescie
		// Warszawa-> 36.333333333333336
		// Krakow-> 34.0
		// Królestwo Konstaincina-> 31.0
		Map<String, Double> zestawienieMiastoSredniWiekPacjenta = visits.stream().map(Visit::getPatient).distinct().collect(Collectors.groupingBy(Patient::getCity, Collectors.averagingDouble(Patient::getAge)));
		System.out.println(zestawienieMiastoSredniWiekPacjenta);
		
		// Zestawienie: specjalizacja, sredni wiek danego pacjenta na wizycie
		// Ortopeda-> 40.5
		// Patologia-> 43.4
		// Ginekologia-> 29.2
		// Psychiatria-> 30.0
		// Kardiologia-> 32.4375
		Map<String, Double> zestawienieSpecjalizacjaSredniWiekPacjenta = visits.stream()//
				.collect(Collectors.groupingBy(p-> p.getDoctor().getSpecialization(), Collectors.averagingDouble(a-> a.getPatient().getAge())));
		System.out.println(zestawienieSpecjalizacjaSredniWiekPacjenta);
		
		// zestawienie: miasto -> pacjent z najwieksza liczba wizyt
		// Warszawa-> Marek Szczepanski
		// Krakow-> Anna Kowalska
		// Królestwo Konstaincina-> Bartek Marczak
		Map<String, Optional<Patient>> zestawienieMiastoPacjentZMaxWizyt = visits.stream().map(Visit::getPatient).distinct().collect(Collectors.groupingBy(Patient::getCity, Collectors.maxBy((d1,d2)->d1.getVisits().size()-d2.getVisits().size())));
		System.out.println(zestawienieMiastoPacjentZMaxWizyt);
		
		// list top3 lekarzy ktorzy mieli najwiecej wizyt
		// Genowefa Sercowa, 8
		// Stefan Cipny, 5
		// Zenon Umierający, 5
		List<MedicalDoctor> top3 = visits.stream().map(Visit::getDoctor).distinct().sorted((d1, d2)-> d1.getVisits().size()-d2.getVisits().size()).limit(3).collect(Collectors.toList());
		System.out.println(top3);
		
		// Zestawienie wizyt w czerwcu: dzien w miesiacu -> liczba wizyt dla
		// wszstkich kardiologow

		// 1-> 5
		// 6-> 1
		// 7-> 1
		// 9-> 1
		// 11-> 1
		@SuppressWarnings("deprecation")
		Map<Integer, Long> zestawienieDzienMiesiacDlaKardilogow = visits.stream()//
				.filter(d->d.getDate().getMonth()==Calendar.JUNE)//
				.filter(v-> v.getDoctor().getSpecialization().equals("Kardiologia"))//
				.collect(Collectors.groupingBy(v-> v.getDate().getDate(), Collectors.counting()));
		System.out.println(zestawienieDzienMiesiacDlaKardilogow);
		
		// zestawienie: lekarz -> miesaic -> liczba wizyt
		@SuppressWarnings("deprecation")
		Map<MedicalDoctor, Map<Integer, Long>> zestawienieLekarzMiesiacLiczbaWizyt = visits.stream()//
				.distinct().collect(Collectors.groupingBy(Visit::getDoctor, Collectors.groupingBy(d -> d.getDate().getMonth(), Collectors.counting())));
		System.out.println(zestawienieLekarzMiesiacLiczbaWizyt);
		
		// Zenon Umierający
		// Czerwie-> 2
		// Pazdziernik-> 1
		// 11-> 1
		// 12-> 1
		// Mirosław Psycho
		// 2-> 1
		// 4-> 1
		// 6-> 1
		// 10-> 1
		// Kazimierz Jupiter
		// 6-> 2
		// Rudolf Jupiter
		// 6-> 2
		// Stefan Cipny
		// 4-> 1
		// 6-> 1
		// 12-> 3
		// Judyna Jupiter
		// 6-> 2
		// 8-> 1
		// Angelika Lubiloda
		// 3-> 1
		// 6-> 1
		// 7-> 1
		// Marlena Jupiter
		// 6-> 2
		// Genowefa Sercowa
		// 2-> 1
		// 3-> 1
		// 4-> 1
		// 5-> 1
		// 6-> 4


	}

	public static Date data(int rok, int miesiac, int dzien, int godzina, int minuta) {
		Calendar cal = Calendar.getInstance();
		cal.set(rok, miesiac - 1, dzien, godzina, minuta);
		return cal.getTime();
	}
}
