package main;

import myCls.myClass;

public class mainClass {

	public static void main(String[] args) {
		
		/*
			
			Object Oriented Programming
			
			<절차 지향 순번>			<객체 지향 순번 - 분산처리>
			초기화(변수 선언)			처리에따라서 변수처리 함
			
			처리1					처리1, 처리2, 처리3
			처리2
			처리3
			
			결과
			
								class
								변수, 함수(메서드)
								
			객체지향의 성질
			1. 은닉성(== 캡슐화)
			   : 외부와의 (접근)차단으로 변수들을 관리하기 위한 목적
				class의 내부에서 접근을 제어하도록 접근지정자로 지정한다.
				
				private(개인적인) 	-> 멤버변수
				public(대중적인) 	-> 멤버메서드
				protected(특정)	-> 상속에 관련되어 있는 지정자
				
			
			2. 상속성
			3. 다형성
			
		*/
		
		myClass cls = new myClass();
		cls.name = "홍길동";
		//cls.number = 12; -> 이 영역에서 접근할 수 없다는 오류가 발생
		//cls.c = 'a'; -> 오류
		cls.setNumber(12);	//매개변수로 number에 12를 넣어주고
		int n = cls.getNumber();	//넣어준 12인 number를 리턴값으로 내보냄
		System.out.println(n);	//12
		
		System.out.println("cls heap 주소 : "+cls);
		System.out.println(cls.getThis());
		
		myClass mcls = new myClass();	
		//새로운 변수명의 저장소를 준다면 또 다른 주소값이 나옴
		System.out.println("mcls heap 주소 : "+mcls);
		System.out.println(mcls.getThis());
	}

}
