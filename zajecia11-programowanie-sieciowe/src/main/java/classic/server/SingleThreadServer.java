package classic.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9000);
		ExecutorService executor = Executors.newFixedThreadPool(50);

		//wczytanie komunikatu od klienta (Stringa) zamiana go na wielkie litery i odeslanie
		//klient: hello, server: HELLO

		while (true) {
			Socket client = ss.accept();
			System.out.println("Polaczyl sie klient: " + client.getInetAddress().getHostAddress());
			ClientProcessThread cpt = new ClientProcessThread(client);
			executor.submit(cpt);
		}

	}

	public static class ClientProcessThread implements Callable<Void> {
		private Socket client;
		private BufferedReader in;
		private PrintWriter out;

		public ClientProcessThread(Socket client) throws Exception {
			this.client = client;
			//musimy pobrac dwa strumienie: wejsciowy do wczytywania
			//wyjsciowy do pisania komunikatow
			this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			this.out = new PrintWriter(client.getOutputStream(), true);
		}
		
		@Override
		public Void call() throws Exception {
			String komunikat = in.readLine();
			Thread.sleep(15000);
			String response = komunikat.toUpperCase();
			out.println(response);
			in.close();
			out.close();
			client.close();
			return null;
		}


	}

}
