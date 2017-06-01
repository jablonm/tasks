package main;
import java.util.concurrent.atomic.AtomicInteger;

public class Person implements Comparable<Person> {
	private static final AtomicInteger GENERATOR = new AtomicInteger();

	private int id;
	private String name;
	private String secondname;
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person(String name, String secondname, int age) {
		this.name = name;
		this.secondname = secondname;
		this.age = age;
		this.id = GENERATOR.incrementAndGet();
	}

	@Override
	public int compareTo(Person o) {
		return this.compareTo(o);
	}

}
