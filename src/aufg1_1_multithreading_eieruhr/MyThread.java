package aufg1_1_multithreading_eieruhr;

public class MyThread extends Thread {
	
	int sec;
	String alarm;
	
	public MyThread(int sec, String alarm) {
		this.sec = sec;
		this.alarm = alarm;
	}
	public void run() {
		for(int i = sec; i>0; i--) {
			System.out.println("Noch " + sec + " Sekunden");
			schlafen(1);
			sec -= 1;
		}
		System.out.println(alarm);
	}
	
	public static void schlafen (int m) {
		try {
			// Warte für m Sekunden
			Thread.sleep(1000*m);
		} catch (InterruptedException t) {
			
		}
	}
	
	
}
