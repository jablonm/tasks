import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fare {

	//	Anywhere in Zone 1  £2.50
	//	Any one zone outside zone 1  £2.00
	//	Any two zones including zone 1  £3.00
	//	Any two zones excluding zone 1  £2.25
	//	Any three zones  £3.20
	//	Any bus journey   £1.80
	//	The maximum possible fare is therefore £3.20.

	private Map<String, BigInteger> fares = new HashMap<>();

	public Fare() {
		fares.put("atz", new BigInteger("320"));
		fares.put("aiz1", new BigInteger("250"));
		fares.put("aozoz1", new BigInteger("200"));
		fares.put("atziz1", new BigInteger("300"));
		fares.put("atzez1", new BigInteger("225"));
		fares.put("abj", new BigInteger("150"));
		fares.put("max", new BigInteger("320"));
	}

	public BigInteger getFares(Station from, Station to) {
		if (anyThreeZones(from, to)) {
			return fares.get("atz");
		} else if (anywhereInZone1(from, to)) {
			return fares.get("aiz1");
		} else if (anyOneZoneOutsideZone1(from, to)) {
			return fares.get("aozoz1");
		} else if (anyTwoZonesIncludingZone1(from, to)) {
			return fares.get("atziz1");
		} else if (anyTwoZonesExcludingZone1(from, to)) {
			return fares.get("atzez1");
		} else {
			return fares.get("max");
		}
	}

	public boolean anyThreeZones(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		System.out.println("Count as any three zones.");
		return ((fromZones.contains(1) && toZones.contains(3)) || (fromZones.contains(3) && toZones.contains(1)));
	}

	public boolean anywhereInZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		System.out.println("Count as anywhere in zone 1.");
		return (fromZones.contains(1) && toZones.contains(1) && !toZones.contains(2) && !toZones.contains(3));
	}

	public boolean anyOneZoneOutsideZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		System.out.println("Anyone zone outside zone 1.");
		return (!fromZones.contains(1) && !toZones.contains(1));
	}

	public boolean anyTwoZonesIncludingZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		System.out.println("Any two zones including zone 1.");
		return (fromZones.contains(1) || toZones.contains(1));
	}

	public boolean anyTwoZonesExcludingZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		System.out.println("Any two zones excluding zone 1.");
		return ((fromZones.contains(2) || fromZones.contains(3)) && (toZones.contains(2) || toZones.contains(3)));
	}

}

