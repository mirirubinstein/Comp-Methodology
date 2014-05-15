package rubinstein.homework;

public class Circle2D {
	private double x;
	private double y;
	private double radius;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public Circle2D() {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}

	public double getPerimeter() {
		double perimeter = Math.PI * radius * 2;
		return perimeter;
	}

	public boolean contains(double x, double y) {
		double distance = Math.sqrt(Math.pow((this.x - x), 2)
				+ Math.pow((this.y - y), 2));
		if (distance < radius){
			return true;
		}else{
			return false;
		}
	}

	public boolean contains(Circle2D circle) {
		double distance = Math.sqrt(Math.pow((this.x - circle.getX()), 2)
				+ Math.pow((this.y - circle.getY()), 2))
				+ circle.getRadius();
		if (distance < radius)
			return true;
		else
			return false;
	}

	public boolean overlaps(Circle2D circle) {
		double distance = Math.sqrt(Math.pow((this.x - circle.getX()), 2)
				+ Math.pow((this.y - circle.getY()), 2));
		double radiusLength = radius + circle.getRadius();
		if (distance < radiusLength)
			return true;
		else
			return false;
	}

}
