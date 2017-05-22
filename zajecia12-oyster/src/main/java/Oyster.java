import java.math.BigDecimal;

public class Oyster {

	private BigDecimal debit;
	private BigDecimal actualRide = new BigDecimal("0");
	private Ride ride;
	private Fare fare = new Fare();

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
		this.ride = ride;
		if (ride.getStart()) {
			this.pay(fare.getMax());
			ride.startRide();
			actualRide = BigDecimal.ZERO;
		} else {
			ride.startRide();
		}
	}

	public void stopRide(Ride ride, Boolean bus) {
		this.ride = ride;
		this.pay(fare.getFares(ride.getStartStation(), ride.getStopStation(), bus));
		ride.stopRide();
	}

	public void pay(BigDecimal value) {
		if (checkPay(value)) {
			if (actualRide.subtract(fare.getMax()).signum() > 0) {
				debit = debit.subtract(fare.getMax());
				// actualRide = actualRide.add(value);
				System.out.println("Koszt przejazdu: " + actualRide.toString());
				System.out.println("Saldo: " + debit.toString());
			} else {
				debit = debit.subtract(value);
				actualRide = actualRide.add(value);
				System.out.println("Koszt przejazdu: " + actualRide.toString());
				System.out.println("Saldo: " + debit.toString());
			}
		}
	}

	private Boolean checkPay(BigDecimal value) {
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
