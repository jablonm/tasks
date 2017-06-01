package persons;

public class Person {

	private String name;
	private String secondname;
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public Person(String name, String secondname, String age) {
		this.name = name;
		this.secondname = secondname;
		this.age = age;
	}
}
