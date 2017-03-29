import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Zadanie5 {
	public static void main(String[] args) {
		/*
		 * Stworz klase Impreza ktora ma, nazwe, miejsce, i Liste Dat
		 * (java.util.date) zrob klase immutable.
		 */
	}

	static final class Impreza {
		private final String nazwa;
		private final String miejsce;
		private final ArrayList<Date> daty;

		public Impreza(String nazwa, String miejsce, ArrayList<Date> daty) {
			this.nazwa = nazwa;
			this.miejsce = miejsce;
			
			if (daty == null) {
				this.daty = null;
			} else {
				this.daty = daty.stream().map(e -> new Date(e.getTime())).collect(Collectors.toCollection(ArrayList::new));
			}
		}

		public String getNazwa() {
			return nazwa;
		}

		public String getMiejsce() {
			return miejsce;
		}

		public ArrayList<Date> getDaty() {
			if (daty == null) {
				return null;
			}
			return daty.stream().map(e -> new Date(e.getTime())).collect(Collectors.toCollection(ArrayList::new));
		}

		@Override
		public String toString() {
			return "Impreza [nazwa=" + nazwa + ", miejsce=" + miejsce + ", daty=" + daty + "]";
		}

	}

}
