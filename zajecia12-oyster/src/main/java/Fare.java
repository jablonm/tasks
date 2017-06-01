import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fare {

	// Anywhere in Zone 1 £2.50
	// Any one zone outside zone 1 £2.00
	// Any two zones including zone 1 £3.00
	// Any two zones excluding zone 1 £2.25
	// Any three zones £3.20
	// Any bus journey £1.80
	// The maximum possible fare is therefore £3.20.

	private Map<String, BigDecimal> fares = new HashMap<>();

	public Fare() {
		fares.put("atz", new BigDecimal("3.20"));
		fares.put("aiz1", new BigDecimal("2.50"));
		fares.put("aozoz1", new BigDecimal("2.00"));
		fares.put("atziz1", new BigDecimal("3.00"));
		fares.put("atzez1", new BigDecimal("2.25"));
		fares.put("abj", new BigDecimal("1.50"));
		fares.put("max", new BigDecimal("3.20"));
		fares.put("bus", new BigDecimal("1.80"));
	}

	public BigDecimal getMax() {
		return fares.get("max");
	}
	
	public BigDecimal getFares(Station from, Station to, Boolean bus) {
		if (to == null) { 
			return fares.get("max");
		} else if (bus) {
			return fares.get("max");
		} else {
			if (anywhereInZone1(from, to)) {
				return fares.get("aiz1");
			} else if (anyOneZoneOutsideZone1(from, to)) {
				return fares.get("aozoz1");
			} else if (anyTwoZonesIncludingZone1(from, to)) {
				return fares.get("atziz1");
			} else if (anyTwoZonesExcludingZone1(from, to)) {
				return fares.get("atzez1");
			} else if (anyThreeZones(from, to)) {
				return fares.get("atz");
			} else {
				return fares.get("max");
			}
		}
	}

	// 1,2-3
	// 3-1,2
	private boolean anyThreeZones(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		//System.out.println("Count as any three zones.");
		return ((fromZones.contains(1) && fromZones.contains(2) && !fromZones.contains(3) && //
				toZones.contains(3) && !toZones.contains(2) && !toZones.contains(1)) || //
				(fromZones.contains(3) && !fromZones.contains(2) && !fromZones.contains(1) && //
						toZones.contains(1) && toZones.contains(2) && !toZones.contains(3)));
	}

	// 1-2
	// 2-1
	// 1,2-1
	// 1-1,2
	private boolean anywhereInZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		//System.out.println("Count as anywhere in zone 1.");
		return ((fromZones.contains(1) && !fromZones.contains(2) && toZones.contains(2) && !toZones.contains(1)) || //
				(fromZones.contains(2) && !fromZones.contains(1) && toZones.contains(1)) && !toZones.contains(2) || //
				(fromZones.contains(1) && fromZones.contains(2) && toZones.contains(1)) || //
				(fromZones.contains(1) && toZones.contains(2) && toZones.contains(1)));
	}

	// 2-2
	// 3-3
	private boolean anyOneZoneOutsideZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		//System.out.println("Anyone zone outside zone 1.");
		return ((fromZones.contains(2) && !fromZones.contains(1) && !fromZones.contains(3) && //
				toZones.contains(2) && !toZones.contains(1) && !toZones.contains(3)) || //
				fromZones.contains(3) && !fromZones.contains(2) && fromZones.contains(1) && //
						toZones.contains(3) && !toZones.contains(2) && !toZones.contains(1));
	}

	// 1-2
	// 2-1
	// 1-3
	// 3-1
	private boolean anyTwoZonesIncludingZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		//System.out.println("Any two zones including zone 1.");
		return ((fromZones.contains(1) && !fromZones.contains(2) && !fromZones.contains(3) && //
				toZones.contains(2) && !toZones.contains(1) && !toZones.contains(3)) || //
				(fromZones.contains(2) && !fromZones.contains(1) && !fromZones.contains(3) && //
						toZones.contains(1) && !toZones.contains(2) && !toZones.contains(3))
				|| //
				(fromZones.contains(1) && !fromZones.contains(2) && !fromZones.contains(3) && //
						toZones.contains(3) && !toZones.contains(1) && !toZones.contains(2))
				|| //
				(fromZones.contains(3) && !fromZones.contains(2) && !fromZones.contains(1) && //
						toZones.contains(1) && !toZones.contains(2) && !toZones.contains(3)));
	}

	// 2-3
	// 3-2
	private boolean anyTwoZonesExcludingZone1(Station from, Station to) {
		Set<Integer> fromZones = from.getZonesNumber();
		Set<Integer> toZones = to.getZonesNumber();
		//System.out.println("Any two zones excluding zone 1.");
		return ((fromZones.contains(2) && toZones.contains(3)) || //
				(fromZones.contains(3) && toZones.contains(2)));
	}

}
