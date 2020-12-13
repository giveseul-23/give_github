package mainClass;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
			Stack : First In Last Out
		*/
		/*
		StackClass stack = new StackClass(5);
		
		String str = "one";
		stack.push(str);
		
		String peekstr = (String)stack.peek();
		System.out.println("top object : "+ peekstr);
		
		str = "two";
		stack.push(str);
		
		peekstr = (String)stack.peek();
		System.out.println("top object : "+ peekstr);
		
		String popStr = (String)stack.pop();
		System.out.println("삭제된 object : "+ popStr);
		
		peekstr = (String)stack.peek();
		System.out.println("top object : "+ peekstr);
		
		Integer i = 111;
		stack.push(i);
		
		Integer t = (Integer)stack.peek();
		System.out.println("top object : "+ t);
		*/
		StackClass stack = new StackClass(5);
		
		while(true) {
			
			System.out.println("1. 입력");
			System.out.println("2. 삭제");
			System.out.println("3. 정보출력");
			System.out.println("4. 종료");
			System.out.print("선택하실 작업을 입력 : ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1 : 
					System.out.print("입력할 내용 : ");
					String name = sc.next();
					stack.push(name);
					break;
				case 2 : 
					System.out.print("삭제");
					name = (String)stack.pop();
					break;
				case 3 : 
					System.out.println("현재 최상단 내용");
					String name1 = (String) stack.peek();
					System.out.println(name1);
					break;
			}
			
			if(num == 4) {
				break;
			}
		}
		
		
		
	}

}
