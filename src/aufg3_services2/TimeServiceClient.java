package aufg3_services2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TimeServiceClient {

	public static void main(String[] args) {
		
		String ip = "127.0.0.1";
		System.out.println(timeFromServer(ip));

	}
	
	public static String timeFromServer(String ip) {
		String time = null;
		try {
			Socket clientSocket = new Socket(ip, 75);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			System.out.println(reader.readLine());
			
			writer.write("time");
			writer.newLine();
			writer.flush();
			
			time = reader.readLine();
			
			// System.out.println(time);
			
			return time;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	
	//public static String timeFromServer(String ip) {
		
	//}

}
