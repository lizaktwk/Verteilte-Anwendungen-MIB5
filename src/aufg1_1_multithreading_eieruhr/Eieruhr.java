package aufg1_1_multithreading_eieruhr;

public class Eieruhr {
	
	public static void eieruhr(int sec, String alarm) {
		Thread thread = new MyThread(sec, alarm);
		thread.start();
		
	}

}
