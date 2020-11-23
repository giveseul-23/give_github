package main;

public class QueueClass {
	private int front;
	private int rear;
	private int maxSize;
	private Object queueArray[];
	
	public QueueClass(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new Object[maxSize];
		
		front = 0;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return (front == rear +1); //true
	}
	
	public boolean isFull() {
		return (rear == maxSize -1); //true
	}
	
	//추가
	public void push(Object obj) {
		if(isFull()) {
			System.out.println("공간이 가득찼습니다.");
			return;
		}
		
		rear++;	//계속입력할수록 앞으로 전진
		queueArray[rear] = obj;
		
	}
	
	//삭제
	public Object pop() {
		Object obj = peek();
		
		if(front > maxSize -1) {
			//가득찬 상태
			return null;
		}
		
		front++;//가득차지 않았다면 ++
		return obj;
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("데이터가 없습니다.");
			return null;
		}
		
		return queueArray[front];
	}
	
}
