package aufg1_2_multithreading_dispatcher;


public class Execute implements F{
	
	public static int[] execute(F f, int n) {
		for(int x = 0; x < n; x++) {
		Thread thread = new MyThread(f, x);
		thread.start();
		}

	}

	@Override
	public int f(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
