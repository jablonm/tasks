import com.google.common.collect.Sets;

public class Main {
	
	public static void main(String[] args) {

		Station holborn = new Station("Holborn", Sets.newHashSet(new Zone(1)));
		Station earl = new Station("Earl’s Court", Sets.newHashSet(new Zone(1), new Zone(2)));
		Station wimbledon = new Station("Wimbledon", Sets.newHashSet(new Zone(3)));
		Station hammersmith = new Station("Hammersmith", Sets.newHashSet(new Zone(2)));
		Fare fare = new Fare();
		
		System.out.println(fare.getFares(hammersmith, holborn));
		
	}
}
