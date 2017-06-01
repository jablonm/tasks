import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Oyster {

	private BigDecimal debit;
	private BigDecimal actualRide = new BigDecimal("0");
	private Fare fare = new Fare();
	private Set<Ride> rides = new HashSet<>();
	private Set<Ride> ridesHistory = new HashSet<>();

	public BigDecimal getDebit() {
		return debit;
	}

	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}

	public Oyster(BigDecimal debit) {
		this.debit = debit;
	}

	public void startRide(Ride ride) {
		for (Ride rideToRun : rides) {
			if (rideToRun.getStart() && !rideToRun.getStop()) {
				rideToRun.setStopStation(null);
				stopRide(rideToRun);
			}
		}
		
		rides.add(ride);
		ride.startRide();
	}

	public void stopRide(Ride ride) {
		pay(fare.getFares(ride.getStartStation(), ride.getStopStation(), ride.getBus()));
		ride.stopRide();
		actualRide = BigDecimal.ZERO;
	}

	public void pay(BigDecimal value) {
		if (checkPayment(value)) {
			debit = debit.subtract(value);
			actualRide = actualRide.add(value);
			System.out.println("Koszt przejazdu: " + actualRide.toString());
			System.out.println("Saldo: " + debit.toString());
		}
	}

	private Boolean checkPayment(BigDecimal value) {
		if (debit.subtract(value).signum() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void charge(BigDecimal value) {
		this.setDebit(value);
	}

}
