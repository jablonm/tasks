package main;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {

	private static final AtomicInteger GENERATOR = new AtomicInteger();
	
	private String marka;
	private String model;
	private int moc;
	private int przebieg;
	private String paliwo;
	private int id;
	
	public Car(String marka, String model, int moc, int przebieg, String paliwo) {
		this.marka = marka;
		this.model = model;
		this.moc = moc;
		this.przebieg = przebieg;
		this.paliwo = paliwo;
		this.id = GENERATOR.incrementAndGet();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMoc() {
		return moc;
	}

	public void setMoc(int moc) {
		this.moc = moc;
	}

	public int getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(int przebieg) {
		this.przebieg = przebieg;
	}

	public String getPaliwo() {
		return paliwo;
	}

	public void setPaliwo(String paliwo) {
		this.paliwo = paliwo;
	}
	
}
