package shapeClass_t;

public class Circle extends shape {
	
	double r;
	
	public Circle() {
		
	}
	
	public Circle(double r) {
		this.r = r;
	}
	
	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return r * r * 3.14;
	}

}
