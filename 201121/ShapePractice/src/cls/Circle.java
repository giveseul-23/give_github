package cls;

public class Circle extends Shape{
	double r;
	
	public Circle() {
		
	}
	
	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double calcArea() {
		return r * r * 3.14;
	}
	
	
}
