import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Station {

	private String name;
	private Set<Zone> zones = new HashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Zone> getZones() {
		return zones;
	}
	public void setZones(Set<Zone> zones) {
		this.zones = zones;
	}
	
	public Set<Integer> getZonesNumber() {
		Set<Integer> zonesNumber = zones.stream().map(Zone::getNumber).collect(Collectors.toSet());
		return zonesNumber;
	}
	public Station(String name, Set<Zone> zones) {
		this.name = name;
		this.zones = zones;
		System.out.println("Dodano stacjê: " + name);
	}
	
	
 	
}
