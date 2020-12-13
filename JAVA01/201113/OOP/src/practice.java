
public class practice {

	public static void main(String[] args) {

		/*
		
			만약 소스코드가 5만줄 이상이 된다면 
			1. 알아보기 힘들다
			2. 흔한 변수명들끼리 충돌할 것이다.
			3. 크기에는 한계가 있다
			4. 유지보수하기 힘들다
			> 그래서 OPP(Object Oriented Programming)이 필요하다.
			
			Object란?
			
			클래스 형식에서 설명할수있는데
			
			클래스를 먼저 정의
			class 클래스명{
				변수들
				함수(메서드)들
			}
			
			->
			
			클래스 선언해준다.
			클래스명 변수 = new 클래스명();
					-> 여기서 해당 변수를 object, 객체라고 한다.
					
			변수.메서드;
			
		
		*/
		
		yaya obc = new yaya();
		obc.c = 'a';
		obc.i = 123;
		//obc.str = "hello";
		obc.print();
		
		
		
		whatstv user = new whatstv();
		user.b = "sam";
		user.ch = 1;
		user.p = false;
		user.print();
		
		whatstv user2 = new whatstv();
		user2.b = "lg";
		user2.ch = 2;
		user2.p = true;
		user2.print();
	}

}


class yaya{
	char c;
	int i;
	//String str;
	
	void print() {
		System.out.println(c+" "+i);
	}
}

class whatstv{
	String b;
	int ch;
	boolean p;
	
	void print() {
		System.out.println("브랜드명 : "+b+" 채널번호 : "+ch+" 전원은 : "+p);
	}
}

