package main;

public class MyClass {

	private int memberVar;	//멤버변수		-> (MyClass)클래스 내부에서 다 사용가능, heap영역에 저장되는 부분
	static int staticVar;	
	//정적변수  -> 프로그램 동작을 실행할때부터 이미 고정이 되어있음(처음부터 끝까지 함께함 - 계속 사용하면 무거워짐)
	
	public void method() {
		int localVar = 0;	//지역변수		//초기화됨
		localVar++;
		memberVar++;
		staticVar++;
		
		System.out.println("지역변수 : "+localVar+", 멤버변수 : "+memberVar+", 정적변수 : "+staticVar);
		
	}
	
	/*인스턴스 메서드
	
		MyClass c = new MyClass();
		c.method(); <- c.~~
	
	*/
	public void func() {
		
		
	}
	
	//스테틱 메서드

	public static void staticMethod() {
		System.out.println("staticMethod() 호출");
		
		//this사용X, this로 접근할수없음
		//super(); 사용x
	}
	
	
	//생성시에 처리할 내용이 많으면 해당경우처럼 사용
	public static MyClass getInstance() {
		MyClass c = new MyClass();
		c.func();
		
		
		return c;
	}
	
	
}
