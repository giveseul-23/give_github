package cls;

import pcls.ParantClass;

public class ChildClass extends ParantClass{
	public ChildClass() {
		System.out.println("PareantClass ChildClass()");
	}
	
	public void childMethod() {
		setPrivate_num(12);
		int n = getPrivate_num();
		
		public_num =123;
		protected_num = 456;
		
		parant_ProtectedMethod();
		
		System.out.println("ChildClass childMethod() n = "+n);
	}
}
