package aufg1_1_multithreading_eieruhr;

public class Main {

	public static void main(String[] args) {
		int n = 3;
		Eieruhr.eieruhr(n, "Timer nach " + n + " s abgelaufen");
		System.out.println("I should be executed immediately");
	}

}
