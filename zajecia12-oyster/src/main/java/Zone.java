import java.util.HashSet;
import java.util.Set;

public class Zone {
	private int number;
	private Set<Station> stations = new HashSet<>();
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Station> getStations() {
		return stations;
	}

	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}

	public Zone(int number) {
		this.number = number;
	}
	
}
