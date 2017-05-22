import java.math.BigDecimal;

import com.google.common.collect.Sets;

public class Main {
	
	public static void main(String[] args) {

		Station holborn = new Station("Holborn", Sets.newHashSet(new Zone(1)));
		Station earl = new Station("Earl's Court", Sets.newHashSet(new Zone(1), new Zone(2)));
		Station wimbledon = new Station("Wimbledon", Sets.newHashSet(new Zone(3)));
		Station hammersmith = new Station("Hammersmith", Sets.newHashSet(new Zone(2)));

		Oyster oyster = new Oyster(new BigDecimal("30"));
		Ride ride = new Ride(true, holborn);
		oyster.startRide(ride);
		Ride ride2 = new Ride(true, wimbledon);
		oyster.startRide(ride2);
		ride2.setStopStation(hammersmith);
		oyster.stopRide(ride2, true);
	}
}
