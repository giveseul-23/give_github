package childone;

import parent.Parent;

public class ChildOne extends Parent {
	
	
	public void method() {
		System.out.println("ChildOne OverRide method()");
	}
	
	
	public void func() {
		//super.method();
		System.out.println("ChildOne func()");
	}
	
}
