package main;

import cls.ChildClass;

public class mainClass {

	public static void main(String[] args) {
		
		/*
		
			은닉성 : 접근지정자를 통해서 외부로부터 접근을 차단, 허용해 주는 것을 의미
					private(거의 변수에 사용), public(메소드에 주로 사용), protected
			
			상속성 : 부모클래스(super)에서 기능을 상속하는 것을 의미
					추가기입을 할 수 있다(Over Ride)
			
					-> 클래스 하나당 하나만 상속받을 수 있음
			
			다형성 : 상속 후에 여러 형태의 자식클래스를 제작 
			
					부모 클래스 - 직사각형
			자식클래스 - 정사각형 		마름모 	삼각형		-> 상속이 이뤄진 후 여러가지 형태로 나눠짐
			
		
		*/
		
		ChildClass cc = new ChildClass();
		//생성자 호출시 부모클래스 먼저호출 후 자식클래스 생성자가 호출된다.
		
	//	cc.parantMethod();
		cc.childMethod();
		cc.public_num = 345;	//부모클래스의 public 변수는 호출 가능
		
		//cc.protected_num = 567; - > 오류
		//cc.parant_ProtectedMethod(); -> Protected라 오류
		//protected는 자식클래스에서만 접근가능하고 외부에서는 접근할 수 없다.
		
		//	ParantClass pc = new ParantClass();
		
	}

}
