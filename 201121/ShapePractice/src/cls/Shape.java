package cls;

import java.awt.Point;

public abstract class Shape {
	Point p;	//Point라는 클래스를 불러옴
	
	public Shape() {
		this(new Point(0,0));
	}
	
	public Shape(Point p) {
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
