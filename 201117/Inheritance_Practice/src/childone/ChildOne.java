package childone;

import parent.Parent;

public class ChildOne extends Parent {
	
	public void method() {
		/*super.method();//overRide 되기전 (부모클래스의)메소드가 호출*/
		System.out.println("ChildOne OverRide method()");
	}
	
	
	public void ChildOneMethod() {
		System.out.println("ChildOne ChildOneMethod()");
	}
}
