package aufg1_2_multithreading_dispatcher;

public class Result {

	int[] result;
	int counter;
	
	public Result(int n) {
		this.result = new int[n];
		this.counter = 0;
	}
	
	public synchronized void store(int calcResult, int location) {
		result[location] = calcResult;
		counter++;
		if (counter == result.length) {
			notify();
		}
	}
	
	public synchronized int[] collect(){
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Hi");
		}
		return result;
	}
	
}
