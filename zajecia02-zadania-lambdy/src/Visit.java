import java.util.Date;

public class Visit {
	private final Patient patient;
	private final MedicalDoctor doctor;
	private final Date date;
	private final String ailments;

	public Visit(Patient patient, MedicalDoctor doctor, Date date, String ailments) {
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		this.ailments = ailments;
		this.patient.getVisits().add(this);
		this.doctor.getVisits().add(this);
	}

	public Patient getPatient() {
		return patient;
	}

	public MedicalDoctor getDoctor() {
		return doctor;
	}

	public Date getDate() {
		return date;
	}

	public String getAilments() {
		return ailments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ailments == null) ? 0 : ailments.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		if (ailments == null) {
			if (other.ailments != null)
				return false;
		} else if (!ailments.equals(other.ailments))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visit [patient=" + patient.getName() + ", doctor=" + doctor.getName() + ", date=" + date + ", ailments=" + ailments + "]";
	}

}
