package pl.kurs.spring.pesel.command;

public class PeselCommand {

	private String pesel;
	
	private String day;
	private String mounth;
	private String year;
	private String gender;
	
	public PeselCommand(String pesel) {
		this.pesel = pesel;
		
		day = pesel.substring(0,1);
		mounth = pesel.substring(2,3);
		year = pesel.substring(4,5);
		gender = pesel.substring(6,7);
	}

	public String getDay() {
		return day;
	}

	public String getMounth() {
		return mounth;
	}

	public String getYear() {
		return year;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "PeselCommand [pesel=" + pesel + ", day=" + day + ", mounth=" + mounth + ", year=" + year + ", gender=" + gender + "]";
	}
	
}
