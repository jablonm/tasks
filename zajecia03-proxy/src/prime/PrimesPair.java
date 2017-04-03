package prime;

public class PrimesPair {

	private final int from;
	private final int to;
	
	public PrimesPair(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}
	
	public int getTo() {
		return to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + from;
		result = prime * result + to;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrimesPair other = (PrimesPair) obj;
		if (from != other.from)
			return false;
		if (to != other.to)
			return false;
		return true;
	}
	
}
