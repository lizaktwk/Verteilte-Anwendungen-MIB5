package aufg3_2_timeservice_mit_multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServiceMultithreaded {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(75);
			System.out.println("Server is running...");
			
			while (true) {
				Socket clientSocket = serverSocket.accept(); // sobald telnet im Terminal eingegeben wird, wird die Verbindung hergestellt
				System.out.println("Connection accepted by " + clientSocket);

				ConnectionThread thread = new ConnectionThread(clientSocket); // und dann soll dafür ein neuer Thread gestartet werden, der die Connection handlet
				thread.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
		