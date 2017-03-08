package vehicles;

import java.math.BigDecimal;

public class Naprawa {
	
	private String data;
	private String miejsce;
	private BigDecimal koszt;
	private BigDecimal przebieg;
	
	public Naprawa(String data, String miejsce, BigDecimal koszt, BigDecimal przebieg) {
		super();
		this.data = data;
		this.miejsce = miejsce;
		this.koszt = koszt;
		this.przebieg = przebieg;
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

	public BigDecimal getKoszt() {
		return koszt;
	}

	public void setKoszt(BigDecimal koszt) {
		this.koszt = koszt;
	}

	public BigDecimal getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(BigDecimal przebieg) {
		this.przebieg = przebieg;
	}
	
}
