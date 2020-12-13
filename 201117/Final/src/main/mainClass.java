package main;

public class mainClass {

	public static void main(String[] args) {
		//final : 제약
		// 		변수, 메소드
		
		final int MAX = 10;	//상수, 처음에 초기화를 해줘야함, 대입용이라 대부분 대문자로 쓴다
		
		int num;
		
		num = MAX; //define enum  : 상수
		
	}
	
}

//final을 쓰면 상속 금지
final class superClass {
	
	//final을 쓰면 자식클래스에서 over ride 금지
	public final void method() {
		
	}
	
}

/*
class ChildClass extends superClass {
	public void method() {
		
	}
}
*/