package myCls;

public class myClass {
	//private, protected 외부에서 접근X
	
	private int number;	
	//클래스 내부에서만 접근가능	- public class myClass{여기 안!}
	public String name;
	//어디서든지 접근이 가능
	protected char c;
	
	//variable 90% private - 멤버변수는 거의 private이다.(아닌것도있음), 거의사용안함
	
	/*
		//setter
		public void setNumber(int newNumber) {
			number = newNumber; //외부에서 접근하게끔 함
			
		}
		//getter
		public int getNumber() {
			return number; //내부에서 외부로 보내게 함
		}
		
		-> source - generate getters and setters 프로그램 사용하면 간편해짐
	*/
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
		//멤버변수		//매개변수  	
		//--> 같은 변수명을 사용했기때문에 구분을 위해서 this를 사용함
		
		/*
			this : 	자기참조 -> 자기 자신의 주소(객체를 만들어놓은 heap영역의 저장된 주소)
					0번째 매개변수로 자기자신을 가리키는 주소이다
		
		*/
	}
	
	
	
		public myClass getThis() {
			return this;
		}
		
		public void method() {
			
			int number = 10;	//지역변수
			
			number = 12;	//지역변수
			// 	==
			this.number = 14;	//멤버변수
			this.setNumber(23);	
			
		}
	
	
	
}
