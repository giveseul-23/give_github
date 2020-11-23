package main;

public class mainClass {
	public static void main(String[] args) {
		//First In First Out
		
		QueueClass queue = new QueueClass(5);
		
		String str = "one";
		queue.push(str);
		
		String front = (String)queue.peek();
		System.out.println("front = " + front);
		
		str = "two";
		queue.push(str);
		
		front = (String)queue.peek();
		System.out.println("front = " + front);
		
		str = "three";
		queue.push(str);
		
		front = (String)queue.peek();
		System.out.println("front = " + front);
		//계속 one인 이유는 수평정렬로 되어있어서 삭제하지 않는다면 front는 변경이 x
		
		queue.pop(); //첫번째 부분 삭제
		
		front = (String)queue.peek();
		System.out.println("front = " + front); //front = two
		
		queue.pop();//첫번째 부분 삭제
		
		front = (String)queue.peek();
		System.out.println("front = " + front);//front = three
		
	}
}
