import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

	private List<Visit> visits;

	public Patient(String name, String surname, int age, String city) {
		super(name, surname, age, city);
		this.visits = new ArrayList<>();
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

}
