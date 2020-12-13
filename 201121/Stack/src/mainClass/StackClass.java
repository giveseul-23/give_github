package mainClass;

public class StackClass {

	private int top;			//통에서 제일 상위에 있는 공
	private int maxSize;		
	
	private Object stackArray[]; //자료를 담는 통
	
	public StackClass(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;	//통안에 아무것도 없는 상태
		
		stackArray = new Object[maxSize];	//5 - 길이
	}
	
	//통이 비어 있는지?
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//통이 가득차 있는지?
	public boolean isFull() {
		return (top == (maxSize -1));	//실제 갯수 : 길이 -1
	}
	
	//통에 공을 추가?
	public void push(Object obj) {
		if(isFull()) {
			System.out.println("통이 가득 차 있습니다");
			return;	//더이상 넣을수없는 상황
		}
		
		top++;
		stackArray[top] = obj;
		
	}
	
	//통에 공을 뺀다
	public Object pop() {
		Object obj = peek();
		
		if(top <= -1) {
			 System.out.println("통이 비어있습니다.");
			 return null;
		}
		
		top--;
		
		return obj;
	}
	
	//통에들어간 어떤 것의 정보가 무엇인지
	public Object peek() {
		 if(isEmpty()) {
			 //통에 있는 것을 꺼낼수 없는 상태, 통에 아무것도 안들어있음
			 System.out.println("통이 비어있습니다.");
			 return null;
		 }
		 
		 return stackArray[top];
	}
	
}
