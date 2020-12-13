package shapeClass_t;

import java.awt.Point;

public abstract class shape{
	Point p;
	
	public shape() {
		this(new Point(0,0));
	}
	
	public shape(Point p) {
		this.p = p;
	}
	
	public abstract double calcArea();

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}
	
	
	
}
