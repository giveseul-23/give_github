package cls2;

import cls.ParentClass;

public class ChildOneClass extends ParentClass{
	
	private int memberVar = 0; //멤버변수 - heap
	static int staticVar = 0; //정적영역
	
	public void method() {
		int localVar;
		localVar = 0;
		localVar++;
		memberVar++;
		staticVar++;
		
		System.out.println("localVar : "+localVar+", memberVar : "+ memberVar +", staticVar : "+staticVar);
		
	}
	
	public static void st_method() {
		//this x, super x - 둘다 사용할 수없다.
	}
	
	//모든 것을 초기화 할때 static을 사용하기도 한다
	public static ChildOneClass return_method() {
		ChildOneClass c = new ChildOneClass();
		c.method();
		
		return c;
	}
}
