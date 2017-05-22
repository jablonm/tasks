package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientChat {

	private String name;
	private String host;
	private int port;

	public ClientChat(String name, String host, int port) throws Exception {
		this.name = name;
		this.host = host;
		this.port = port;
		Socket socket = new Socket(host, port);
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //true = po ka¿dym println nie trzeba robiæ flush
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		Listen listener = new Listen(in);
		executor.submit(listener);

		Scanner sc = new Scanner(System.in);
		while (true) {
			if (sc.nextLine().length() > 0) { 
				out.println(sc.nextLine());
			}
		}
	}

	private static class Listen implements Callable<Void> {
		private BufferedReader in;

		public Listen(BufferedReader in) throws Exception {
			this.in = in;
		}

		@Override
		public Void call() throws Exception {
			while (true) {
				System.out.println(in.readLine());
			}
		}

	}

}
