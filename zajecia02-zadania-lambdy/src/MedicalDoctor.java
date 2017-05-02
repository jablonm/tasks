import java.util.ArrayList;
import java.util.List;

public class MedicalDoctor extends Person {
	private String specialization;
	private List<Visit> visits;

	public MedicalDoctor(String name, String surname, int age, String city, String specialization) {
		super(name, surname, age, city);
		this.specialization = specialization;
		this.visits = new ArrayList<>();
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalDoctor other = (MedicalDoctor) obj;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalDoctor [specialization=" + specialization + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getAge()=" + getAge() + ", getCity()=" + getCity() + "]";
	}

}
