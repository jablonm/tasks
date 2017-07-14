package main;

import java.util.List;

import org.hibernate.Session;

import main.model.Driver;
import main.model.Vehicle;

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
		
		HibernateUtil connection = HibernateUtil.instance();
		Session sesja = connection.openTransaction();
		
		Driver driver1 = new Driver("Adam", "Adamski");
		Driver driver2 = new Driver("Darek", "Darecki");
		Driver driver3 = new Driver("Mariusz", "Mariuszowy");
		Driver driver4 = new Driver("Tomasz", "Tomecki");
		Driver driver5 = new Driver("Wojciech", "Wojciechowski");
		
		driver1.addVehicle(new Vehicle("BMW", 200));
		driver1.addVehicle(new Vehicle("BMW", 200));
		driver1.addVehicle(new Vehicle("BMW", 200));
		driver1.addVehicle(new Vehicle("Renault", 50));
		driver1.addVehicle(new Vehicle("Mazda", 150));

		driver2.addVehicle(new Vehicle("Audi", 250));
		
		driver3.addVehicle(new Vehicle("Ferrari", 550));
		
		driver5.addVehicle(new Vehicle("BMW", 400));
		driver5.addVehicle(new Vehicle("Skoda", 80));
		
		sesja = connection.openTransaction();
		driver1 = (Driver) sesja.merge(driver1);
		driver2 = (Driver) sesja.merge(driver2);
		driver3 = (Driver) sesja.merge(driver3);
		driver4 = (Driver) sesja.merge(driver4);
		driver5 = (Driver) sesja.merge(driver5);
		
		connection.commitTransaction(sesja);
		
//		 nastepnie osobnej sesji przy uzyciu jednego zapytania pobierz wszystkich kierowcow ktorzy maja:
//		 - auto BMW
//		 - wszystkich kierowoc ktorzy maja min 2 auta
		
		sesja = connection.openTransaction();
		List<Driver> drivers = sesja.createQuery("select distinct d from Vehicle v join v.driver d left join fetch d.vehicles where v.made = :made ").setParameter("made", "BMW").list();
		for (Driver driver : drivers) {
			System.out.println(driver + " " + driver.getVehicles().size());
		}
		connection.commitTransaction(sesja);
		
		sesja = connection.openTransaction();
		//List<Driver> drivers2 = sesja.createQuery("select d from Driver d left join fetch d.vehicles v group by d.id having count(v.made) >= 2").list();
		List<Driver> drivers2 = sesja.createQuery("select distinct d from Driver d left join fetch d.vehicles v group by(d.id) having count(v.made)>=2").list();
		for (Driver driver : drivers2) {
			System.out.println(driver + " " + driver.getVehicles().size());
		}
		connection.commitTransaction(sesja);		
		
		//20:08:09	SELECT      driver0_.id AS id2_0_,     vehicles1_.id AS id3_1_,     driver0_.name AS name2_0_,     driver0_.secondName AS secondName2_0_,     vehicles1_.driverId AS driverId3_1_,     count(vehicles1_.made) AS made3_1_,     vehicles1_.power AS power3_1_,     vehicles1_.driverId AS driverId0__,     vehicles1_.id AS id0__ FROM     Driver driver0_         JOIN     Vehicle vehicles1_ ON driver0_.id = vehicles1_.driverId group by driver0_.id having count (vehicles1_.made) >= 2 LIMIT 0, 1000	Error Code: 1630. FUNCTION hibernate-example.count does not exist. Check the 'Function Name Parsing and Resolution' section in the Reference Manual	0.000 sec

	}
}
