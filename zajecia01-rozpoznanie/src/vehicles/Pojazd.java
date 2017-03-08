package vehicles;

import java.util.ArrayList;

public class Pojazd {
	
	private String marka;
	private String model;
	private int moc;
	private ArrayList<Naprawa> listaNapraw = new ArrayList<>();
	
	public Pojazd(String marka, String model, int moc) {
		this.marka = marka;
		this.model = model;
		this.moc = moc;
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

	public ArrayList<Naprawa> getListaNapraw() {
		return listaNapraw;
	}

	public void dodajNaprawe(Naprawa naprawa) {
		this.listaNapraw.add(naprawa);
	}
	
	public void setListaNapraw(ArrayList<Naprawa> listaNapraw) {
		this.listaNapraw = listaNapraw;
	}

	@Override
	public String toString() {
		return "Pojazd [marka=" + marka + ", model=" + model + ", moc=" + moc + ", napraw=" + listaNapraw.size() + "]";
	}
	
}
