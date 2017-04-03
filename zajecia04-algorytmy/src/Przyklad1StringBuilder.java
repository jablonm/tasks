
public class Przyklad1StringBuilder {
	public static void main(String[] args) {
		//StringBuilder - nie ma synchronized
		//StringBuffer - ma wszystkie metody synchronized (wielowatkowo bezpieczny)
		
		String napis = "ala ma kota";
		long start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder("ala ma kota");
		for(int i=0; i<100000; i++){
			//napis+="ala ma kota";
			sb.append("ala ma kota");
//			if(i%10000==0){
//				System.out.println(i);
//			}
		}
		System.out.println(System.currentTimeMillis()-start);
		//"ala" +"kot"
		//[a,l,a] + [k,o,t]
		//[0,0,0,0,0,0]
		//[a,l,a,0,0,0]
		//[a,l,a,k,o,t]
		//zrodlo = [...]
		
		//[0,.... 10 znakow]
		//dokleja dopoki jest miejsce?
		//miejsce sie skonczylo? 
		//robie tablice 2x wieksza [0..20]
		//40/80/160...
		//codility, hackerrank
		
		//2mb
		//1,1mb -> 2.2mb out of memory
		
		//2mb koniec
		
		
	}
}
