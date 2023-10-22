package aufg1_2_multithreading_dispatcher;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//		could be done like this
//		F f = new FImplemented();
//		execute(f, 8);
//		or like this
		int[] array = execute(new FImplemented(), 8);
		System.out.println(Arrays.toString(array));
	}

	public static int[] execute(F f, int n) {
		
//		int[] result = new int[n];
		Result result = new Result(n);
		
		for (int x = 0; x < n; x++) {
			Thread thread = new MyThread(f, x, result);
			thread.start();
		}
		int[] finalResult = result.collect();
		return finalResult;

	}

}
