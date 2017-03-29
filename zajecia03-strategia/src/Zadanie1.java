
public class Zadanie1 {

	public static void main(String[] args) {
		String equation = "2.5 + 2.1";
		//+,-,*,/
		
		String[] equationArray = equation.split(" ");
		double wynik = 0;
		if (equationArray[1].equals("+")) {
			wynik = Double.parseDouble(equationArray[0]) + Double.parseDouble(equationArray[2]);
		} else if (equationArray[1].equals("-")) {
			wynik = Double.parseDouble(equationArray[0]) - Double.parseDouble(equationArray[2]);
		} else if (equationArray[1].equals("*")) {
			wynik = Double.parseDouble(equationArray[0]) * Double.parseDouble(equationArray[2]);
		} else if (equationArray[1].equals("/")) {
			wynik = Double.parseDouble(equationArray[0]) / Double.parseDouble(equationArray[2]);
		}
			
		System.out.println(wynik);
	}

}
