package main;

import cls.MyClass;

public class mainClass {

	public static void main(String[] args) {
		
		/*
			(초기화 목적을 가짐)
			Constructor : 	생성자	// == Student stu = new Student();
						  	(클래스명과 같은 이름의)메서드
						  	return 값이 없다
						  	Over Load(같은 이름의 함수로 매개변수로 구분)가 가능하다
						  	클래스 생성시에 제일 먼저 호출되면서 자동호출된다(callback)
						  	생략이 가능하다 - 사용유무는 원하는 사항에 따라
						  	생성시에 딱 한번 호출되고 그 이후로는 따로 호출 할 수 없다
						  	
						  	변할수없는 초기값만 넣어줘야 함 - ex) 베이스볼에서 랜덤값 배열 3개
						  	
			Destructor : 	소멸자(c++만 있다)
							반드시 한개
							java에는 없음
							
		
		*/
		
		int array[] = {1, 2, 3};
		
		/*
			Student stu = new Student();
			stu.setName("홍길동");
			stu.setNumber(123);
		*/
		
		//Student stu = {"홍길동", 123}; //이런방식으로 초기화 X
		
	//	MyClass cls = new MyClass();	//<- ()부분에서 constructor로 호출됨
		//클래스가 생성될시 constructor이 호출됨
		
		//cls.setNumber(1001);
		//cls.setName("홍길동");
		
	//	MyClass cls1 = new MyClass(12);
		
		//MyClass cls2 = {123, "홍길동"}; -> 이런방식으로 초기화 불가능
		
		MyClass cls2 = new MyClass(13, "일지매");
		//cls2.MyClass(); -> 오류
		
		/*
		
		//final
		final int num = 12;	//final을 붙이면 (변수->)상수(변할 수 없는 수)로 변경됨
						//12로 완전 고정됨
						 * 대입용으로만 사용가능
						 ex) final it num = 12;
						  	int n;
						  	n = num;
					
						
		num = 24;
		
		*/
		
		
	
	}

}
