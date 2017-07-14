package main;


import org.hibernate.Session;

import main.model.Doctor;
import main.model.Patient;

public class Main2 {
	public static void main(String[] args) {
		/*
		 * Stworz relacje jeden do wiele miedzy Kierowca(imie, nazwisko) a Samochodem(marka, moc)
		 * Kierowca moze miec wiele samochodow, samochod ma jednego kierowce
		 * 
		 * 
		 * w Mainie stworz liste 5ciu kierow, kazdy niech ma po0-3 auta. Zapisz cala strukture do bazy
		 * 
		 * nastepnie osobnej sesji przy uzyciu jednego zapytania pobierz wszystkich kierowcow ktorzy maja:
		 * - auto BMW
		 * - wszystkich kierowoc ktorzy maja min 2 auta
		 */

//		HibernateUtil connection = HibernateUtil.instance();
//		Session sesja = connection.openTransaction();
//		
//		Driver driver1 = new Driver("Adam", "Adamski");
//		Driver driver2 = new Driver("Darek", "Darecki");
//		Driver driver3 = new Driver("Mariusz", "Mariuszowy");
//		Driver driver4 = new Driver("Tomasz", "Tomecki");
//		Driver driver5 = new Driver("Wojciech", "Wojciechowski");
//		
//		driver1 = (Driver) sesja.merge(driver1);
//		driver2 = (Driver) sesja.merge(driver2);
//		driver3 = (Driver) sesja.merge(driver3);
//		driver4 = (Driver) sesja.merge(driver4);
//		driver5 = (Driver) sesja.merge(driver5);
//
//		Vehicle vehivle = new Vehicle("BMW", 200);
//		vehivle = (Vehicle) sesja.merge(vehivle);
//		
//		driver1.addVehicle(vehivle);
//		driver2.addVehicle(vehivle);
//		driver3.addVehicle(vehivle);		
//		
//		connection.commitTransaction(sesja);

		//20:08:09	SELECT      driver0_.id AS id2_0_,     vehicles1_.id AS id3_1_,     driver0_.name AS name2_0_,     driver0_.secondName AS secondName2_0_,     vehicles1_.driverId AS driverId3_1_,     count(vehicles1_.made) AS made3_1_,     vehicles1_.power AS power3_1_,     vehicles1_.driverId AS driverId0__,     vehicles1_.id AS id0__ FROM     Driver driver0_         JOIN     Vehicle vehicles1_ ON driver0_.id = vehicles1_.driverId group by driver0_.id having count (vehicles1_.made) >= 2 LIMIT 0, 1000	Error Code: 1630. FUNCTION hibernate-example.count does not exist. Check the 'Function Name Parsing and Resolution' section in the Reference Manual	0.000 sec

		/*
		 * Stworz relacje wiele do wiele 
		 * miedzy lekarzem a pacjentem
		 * Lekarz moze meoc wielu pacjentow a pacjet moze miec wielu lekarzy
		 * lekarz ma id imie nazwisko spec
		 * pacjent ma id imie nazwisko choroba wiek
		 */
		
		HibernateUtil connection = HibernateUtil.instance();
		Session session =  connection.openTransaction();
		
		
		// Kiedy on byl u tego lekarza?
		// ile kosztowala wizyta?
		// choroba: to nie atrybut pacjenta -> gdzie go umiescic?
		
		Doctor doctor1 = new Doctor("Antoni", "Wywizab", "Dentysta");
		Doctor doctor2 = new Doctor("Magda", "Senna", "Anestezjolog");
		Doctor doctor3 = new Doctor("Tomasz", "Ostry", "Chirurg");
		
		doctor1 = (Doctor) session.merge(doctor1);
		doctor2 = (Doctor) session.merge(doctor2);
		doctor3 = (Doctor) session.merge(doctor3);
		
		Patient patient1 = new Patient("Mariusz", "Mariuszowy", 30, "Leczenie kanalowe");
		patient1 = (Patient) session.merge(patient1);
		
		doctor1.addPatient(patient1);
		patient1.addDoctor(doctor2);
		patient1.addDoctor(doctor3);
		
		connection.commitTransaction(session);
		
	}
}
