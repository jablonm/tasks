package pl.kurs.swing.frame;

public class Letter {

	private Character letter;
	private String sequence;
	private int sequenceSum;
	
	public Letter(Character letter, String sequence) {
		this.letter = letter;
		this.sequence = sequence;
		
		for (Character c : sequence.toCharArray()) {
			sequenceSum += (int)c;
		}
		System.out.println("Utworzono: " + letter + " " + sequence + " " + sequenceSum);
	}
	
	public Letter(String sequence) {
		this.sequence = sequence;
		
		for (Character c : sequence.toCharArray()) {
			sequenceSum += (int)c;
		}
		//System.out.println("Utworzono: " + letter + " " + sequence + " " + sequenceSum);
	}
	
	public Character getLetter() {
		return letter;
	}
	public void setLetter(Character letter) {
		this.letter = letter;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public int getSequenceSum() {
		return sequenceSum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((letter == null) ? 0 : letter.hashCode());
		result = prime * result + ((sequence == null) ? 0 : sequence.hashCode());
		result = prime * result + sequenceSum;
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
		Letter other = (Letter) obj;
//		if (letter == null) {
//			if (other.letter != null)
//				return false;
//		} else if (!letter.equals(other.letter))
//			return false;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		if (sequenceSum != other.sequenceSum)
			return false;
		return true;
	}
	
}
