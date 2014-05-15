package rubinstein.force2d;

public class Force2D {
	private final double x;
	private final double y;

	public Force2D(double x, double y) {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		return Math.sqrt((x * x) + (y * y));
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		double angle = (radians * 180) / Math.PI;
		return angle;
	}

	public Force2D add(Force2D force2d) {
		// double newX = force2d.getX() + x;
		// double newY = force2d.getY() + y;
		Force2D newForce = new Force2D(force2d.getX() + x, force2d.getY() + y);
		return newForce;
	}
}
