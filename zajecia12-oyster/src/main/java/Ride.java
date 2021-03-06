
public class Ride {

	private Boolean start;
	private Boolean stop;
	private Station startStation;
	private Station stopStation;
	private Boolean bus;

	public Boolean getBus() {
		return bus;
	}

	public void setBus(Boolean bus) {
		this.bus = bus;
	}

	public Ride(Station startStation, Boolean bus) {
		this.startStation = startStation;
		this.bus = bus;
	}

	public Station getStartStation() {
		return startStation;
	}

	public void setStartStation(Station startStation) {
		this.startStation = startStation;
	}

	public Station getStopStation() {
		return stopStation;
	}

	public void setStopStation(Station stopStation) {
		this.stopStation = stopStation;
	}

	public Boolean getStart() {
		return start;
	}

	public void setStart(Boolean start) {
		this.start = start;
	}

	public Boolean getStop() {
		return stop;
	}

	public void setStop(Boolean stop) {
		this.stop = stop;
	}

	public void startRide() {
		this.setStart(true);
		this.setStop(false);
	}

	public void stopRide() {
		this.setStop(true);
		this.setStart(false);
	}

}
