package rubinstein.threads;

import java.math.BigInteger;

public class Factorial extends Thread {

	public static BigInteger factorial(long x) {
		BigInteger result = BigInteger.valueOf(1);
		for (long i = x - 1; i > 0; i--) {
			result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	private final long n;

	public Factorial(long n) {
		this.n = n;
	}

	@Override
	public void run() {
		super.run();

		System.out.println("Value: ");
		System.out.println(factorial(1000L));
	}

}
