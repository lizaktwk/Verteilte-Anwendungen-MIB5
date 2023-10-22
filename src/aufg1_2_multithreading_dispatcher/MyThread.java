package aufg1_2_multithreading_dispatcher;

public class MyThread extends Thread {
	
	//"Übergeben Sie jedem der Threads eine der x-Werte 0, 1, ...n-1)
	//sowie das Objekt f
	F f;
	int x;
	Result result;
	
	public MyThread(F f, int x, Result result) {
		this.f = f;
		this.x = x;
		this.result = result;
	}
	
	public void run() {
		//Berechnung von f(x)
		int calcResult = f.f(x);
		result.store(calcResult, x);
//		System.out.println("Position: " + x + "\ncalculated result: " + calcResult);
	}

	
}
