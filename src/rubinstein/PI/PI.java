package rubinstein.PI;

public class PI {
	private double pi;

	public PI() {

		pi = 0;
		for (int i = 1; i < 1000000; i++) {
			double numerator = Math.pow(-1, i + 1);
			double denominator = (2 * i) - 1;
			double answer = numerator / denominator;
			pi += 4 * answer;

		}

	}

	public double getPi() {
		return pi;
	}

}
