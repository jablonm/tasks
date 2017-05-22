package classic.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 9000);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		out.println("hello "+System.currentTimeMillis());
		String odp = in.readLine();
		
		System.out.println("Odpowiedz: "+odp);
		out.close();
		in.close();
		socket.close();
		
	}
}
