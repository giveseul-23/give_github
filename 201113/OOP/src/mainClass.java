
public class mainClass {

	public static void main(String[] args) {
		
		/*
		
			Object Oriented Programming
			객체 		지향		프로그래밍
			
			절차지향

			선언(변수, 배열) 
			- (소스코드)50000만 line이 넘으면
				해결1 - 분산 -> 함수처리
				해결2 - 변수 -> 흔한변수들은 충돌가능성이 높다.
				해결3 - 크기 -> 한계
			1. 초기화
			
			2. 랜덤
				1)세부사항 
				2)세부사항
				
			3. 입력
				1)
				2)
			4. 판단(처리)
			
			5. 결과
			
			
			//학생성적관리
			int student[?][4] = {	//0	1 2 3
				
			}
			
			student
				name
				lang
				math
				eng
				
			클래스 정의	
			class 클래스명{
				변수들
				함수들(메소드들)
			}
			
			형식 : 
					stack	heap
			클래스명 	변수 = new 클래스명();
				변수	==	intstance == 주체
						object	== 객체
		
		*/
		
		MyClass cls	= new MyClass();	//생성
		System.out.println(cls);
		cls.c = 'A';
		cls.n = 123;
		cls.str = "hello";
		
		MyClass cls2 = new MyClass();
		cls2.c = 'B';
		cls2.n = 234;
		cls2.str = "world";
		
		//  TV -> 2대
		
		//절차지향
		String name[] = new String[2];
		int channel[] = new int[2];
		boolean power[] = new boolean[2];
		
		name[0] = "SAMSUNG";
		name[1] = "LG";
		
		channel[0] = 11;
		channel[1] = 24;
		
		power[0] = true;
		power[1] = false;
		
		for (int i = 0; i < power.length; i++) {
			System.out.println("메이커 : "+name[i]+" "+channel[i]+" "+power[i]);
		}
		
		//-----------------
		
		TV tv1, tv2;
		
		tv1 = new TV();
		tv2 = new TV();
		
		tv1.name = "LG";
		tv1.channel = 11;
		tv1.power = true;
		tv1.print();
		
		tv2.name = "SAMSUNG";
		tv2.channel = 24;
		tv2.power = true;
		tv2.print();
		
	}

}


class MyClass{
	
	char c;
	int n;
	String str;
	
}

class TV{
	//변수
	String name;	//member 변수 
	int channel;
	boolean power;
	
	//메서드
	void print() {
		System.out.println("메이커 : "+name+" "+channel+" "+power);
	}
}



