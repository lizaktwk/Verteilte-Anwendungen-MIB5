package aufg2_services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader; // Instanzen der Klassen InputStream und OutputStream realisieren Datenströme (S.66 Skript)
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket; // Instanzen der Klasse Socket realisieren die Endpunkte einer TCP/IP-Verbindung (S.66 Skript)

public class TimeService {

	public static void main(String[] args) {
		
		Socket clientSocket; // Initiator-Socket
		ServerSocket serverSocket; // Beantworter-Socket
		BufferedWriter writer;
		BufferedReader reader;
		
		try {
			serverSocket = new ServerSocket(75);
			System.out.println("Server is running...");
			try {
				while(true) {
					clientSocket = serverSocket.accept();
					try {
						System.out.println("Connection accepted by " + clientSocket);
						
						writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
						reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						
						writer.write("time service");
						writer.newLine();
						writer.flush();
						
						while (true) {
							String s = reader.readLine();
							if(s.equals("date")) {
								writer.write(Clock.date());
								writer.newLine();
								writer.flush();
							}
							else if (s.equals("time")) {
								writer.write(Clock.time());
								writer.newLine();
								writer.flush();
							}
							else if (s.equals("end")) {
								break;
							}
							
						}
					} catch (Exception e) {
					
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
