package rubinstein.threads;

public class FactorialThreads {

	public static void main(String[] args) {
		long x = 1000L;
		Thread t1 = new Factorial(x);
		Thread t2 = new Factorial(x * 2);

		t1.start();
		t2.start();
	}

}
