package aufg3_2_timeservice_mit_multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ConnectionThread extends Thread {
    private Socket clientSocket;

    public ConnectionThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
            try {
				handleConnection(clientSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
        
    }

    // was die Connection tun soll (der Service, der geleistet werden soll), wird nun durch eine Methode umgesetzt, auf die
 	// jeder Thread zugreifen soll
    private void handleConnection(Socket clientSocket) throws IOException {
    	try {
    		
    		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			writer.write("time service");
			writer.newLine();
			writer.flush();

			try {
				while (true) {
					String s = reader.readLine();
					if (s.equals("date")) {
						writer.write(Clock.date());
						writer.newLine();
						writer.flush();
					} else if (s.equals("time")) {
						writer.write(Clock.time());
						writer.newLine();
						writer.flush();
					} else if (s.equals("end")) {
						break;
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
