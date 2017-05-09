package example_1;

public class Windows {
	public static void main(String[] args) throws InterruptedException {
		KartaGrariczna kg = new KartaGrariczna();
		
		Program p1 = new Program("mspaint", kg);
		ProgramSystemowy ps1 = new ProgramSystemowy("symBoisIOX", kg);
		//Program p2 = new Program("phothosop", kg);
		//Program p3 = new Program("winamp", kg);
		
		p1.start();
		Thread.sleep(1500);
		ps1.start();
		//p2.start();
		//p3.start();

	}

	public static class Program extends Thread {
		private final String nazwa;
		private final KartaGrariczna kartaGraficzna;

		public Program(String nazwa, KartaGrariczna kartaGraficzna) {
			this.nazwa = nazwa;
			this.kartaGraficzna = kartaGraficzna;
		}

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				int stanPamieci = kartaGraficzna.operacja();
				
				if (stanPamieci != 0) {
					System.out.println("nazwa: " + nazwa + ", i=" + i + ", stan=" + stanPamieci);
					break;
				}
			}
		}

	}
	
	
	public static class ProgramSystemowy extends Thread {
		private final String nazwa;
		private final KartaGrariczna kartaGraficzna;

		public ProgramSystemowy(String nazwa, KartaGrariczna kartaGraficzna) {
			this.nazwa = nazwa;
			this.kartaGraficzna = kartaGraficzna;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				int stanPamieci = kartaGraficzna.operacjaWewnetrzna();
				if (stanPamieci != 0) {
					System.out.println("nazwa: " + nazwa + ", i=" + i + ", stan=" + stanPamieci);
					break;
				}
			}
		}

	}

	public static class KartaGrariczna {
		private int stanPamieci;
		private int pamiecWewnetrzna;
		
		//dwa monitory - kazdy obiekt moze byc moitorem
		private static final Object MONITOR_1 = new Object();
		private static final Object MONITOR_2 = new Object();
		//uzycie synchronied gwarantuje Ci zamkniecie monitora obiektu -> WTF?
		
		//jezeli uzywasz synchronized na niestatycznej metodzie to monitorem bedzie instacja obiektu na ktorym wywolujesz ta metode
		//KartaGrariczna kg = new KartaGrariczna(); <- kg jest monitorem, zatem KG trzyma locka
		//na statycznej: typ .class danego obiektu, KartaGraficzna.class

		public int operacja() {
			synchronized (MONITOR_1) {
				stanPamieci++;
				//robila jakies duuuze operacje na tej pamieci;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				stanPamieci--;
				return stanPamieci;
			}
		}
		
		
		public int operacjaWewnetrzna(){
			synchronized (MONITOR_2) {
				pamiecWewnetrzna++;
				System.out.println("Operacja wew, wykonana");
				pamiecWewnetrzna--;
				return pamiecWewnetrzna;
			}
		}
	}
}
