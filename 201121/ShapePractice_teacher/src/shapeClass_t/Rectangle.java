package shapeClass_t;

public class Rectangle extends shape {
	
	int width, heigth;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.heigth = height;
	}
	
	public boolean isSquare() {
		boolean b = false;
		
		if(width != 0 & heigth != 0 && width==heigth) {
			b = true;
		}
		
		return b;
	}
	
	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return width * heigth;
	}

}
