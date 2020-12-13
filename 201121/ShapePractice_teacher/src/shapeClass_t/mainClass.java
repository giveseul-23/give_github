package shapeClass_t;

import java.awt.Point;

public class mainClass {

	public static void main(String[] args) {
		shape s = new Circle(2.5);
		double d = s.calcArea();
		System.out.println(d);
		
		shape p = new Rectangle(5,5);
		System.out.println(p.calcArea());
		boolean b = ((Rectangle)p).isSquare();
		
		if(b==true) {
			System.out.println("정사각형");
		}else {
			System.out.println("직사각형");
		}
		
		Point p2 = new Point(10,12);
		shape base = new shape(p2) {

			@Override
			public double calcArea() {
				// TODO Auto-generated method stub
				return (p.getX() * p.getY()) / 2;
			}
		};
		
		System.out.println(base.calcArea());
		
	}

}
