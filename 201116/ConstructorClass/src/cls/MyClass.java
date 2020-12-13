package cls;

public class MyClass {
	
	private int number;
	private String name;
	
	public MyClass(){
		System.out.println("MyClass MyClass()");
	}
	
	public MyClass(int number) {
		//Over Load
		this();
		
		this.number = number;//새로운 생성을 해서 매개변수로 넘겨 초기화시키는게 가능함
		System.out.println("MyClass MyClass(int number)");
	}
	
	public MyClass(int number, String name) {
		this(number);//기본생성자 출력됨 - MyClass()
		
		this.number = number;
		this.name = name;
		System.out.println("MyClass MyClass(int number, String name)");
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
