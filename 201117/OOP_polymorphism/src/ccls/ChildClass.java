package ccls;

import cls.ParantClass;

public class ChildClass extends ParantClass {
	
	private int cnumber;
	
	public ChildClass(){
		System.out.println("ChildClass ChildClass()");
		
	}
	
	public ChildClass(int cnumber, int pnumber) {
		//this();	//자기참조 : heap상에 올라가는 주소(pointer)
		//super(); //부모클래스의 reference(pointer)
		super(pnumber);
		
		System.out.println("ChildClass ChildClass(int cnumber)");
		this.cnumber = cnumber;
	}
	
}
