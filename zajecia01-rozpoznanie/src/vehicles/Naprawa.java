package vehicles;

public class Naprawa {
	
	private String data;
	private String miejsce;
	private Double koszt;
	private Double przebieg;
	private Pojazd pojazd;
	
	public Naprawa(String data, String miejsce, Double koszt, Double przebieg, Pojazd pojazd) {
		this.data = data;
		this.miejsce = miejsce;
		this.koszt = koszt;
		this.przebieg = przebieg;
		this.pojazd=pojazd;
		this.pojazd.dodajNaprawe(this);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMiejsce() {
		return miejsce;
	}

	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}

	public Double getKoszt() {
		return koszt;
	}

	public void setKoszt(Double koszt) {
		this.koszt = koszt;
	}

	public Double getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(Double przebieg) {
		this.przebieg = przebieg;
	}

	public Pojazd getPojazd() {
		return pojazd;
	}

	public void setPojazd(Pojazd pojazd) {
		this.pojazd = pojazd;
	}
	
	
}
