package main;

import cls.Circle;
import cls.Rectangle;
import cls.Shape;

public class MainClass {

	public static void main(String[] args) {
		Shape s = new Circle(2.5);
		System.out.println("원의 넓이 "+s.calcArea());
		
		Shape s1 = new Rectangle(6,5);
		System.out.println("도형의 넓이 : "+s1.calcArea());
		boolean b = ((Rectangle)s1).isSquare();
		
		if(b==true) {
			System.out.println("정사각형입니다.");
		}else {
			System.out.println("직사각형입니다.");
		}
	}

}
