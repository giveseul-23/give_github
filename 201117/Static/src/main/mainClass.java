package main;

public class mainClass {
	public static void main(String[] args) {
		
		/*
		
			static : 정적
					
					stack 	heap 	static 	sys
					지역변수	동적할당	정적영역	
									10
		
		*/
		
	//	MyClass cls = new MyClass();
	//	cls.method();//이 부분이 실행될때만 멤버변수가 사용됨
		
	//	MyClass.staticVar = 12; //해당부분처럼 staticVar을 호출해줌
		
		/*
		MyClass c = new MyClass();
		c.method();	//지역변수 : 1, 멤버변수 : 1, 정적변수 : 1
		c.method();	//지역변수 : 1, 멤버변수 : 2, 정적변수 : 2
		c.method();	//지역변수 : 1, 멤버변수 : 3, 정적변수 : 3
		
		MyClass cls = new MyClass();
		cls.method();	//지역변수 : 1, 멤버변수 : 1, 정적변수 : 4
		//정적변수는 공동영역을 사용하기 때문에 
		//위에서 값이 3으로 이미 값이 증가해서 새로운 인스턴스 생성한다고 하더라도 증가한 값에서 변한다
		*/
		
		
		//static 메서드 사용방법
		MyClass.staticMethod(); //이런 방식으로 호출가능
		
		MyClass mcls = MyClass.getInstance(); //static 메서드 호출
		
		
	}
}
