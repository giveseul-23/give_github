package Main;

import Stack.StackClass;

public class mainClass {

	public static void main(String[] args) {
		
		StackClass as = new StackClass();
		
		String str1 = "AAAAA";
		as.push(str1);
		
		String peekstr = (String)as.peek();
		System.out.println("top Object : "+peekstr); //AAAAA
		
		str1 = "BBBBB";
		as.push(str1);
		
		peekstr = (String)as.peek();
		System.out.println("top Object : "+peekstr);	//BBBBB
		
		String delStr = (String)as.pop(); //지움
		
		peekstr = (String)as.peek();
		System.out.println("top Object : "+peekstr);	//AAAAA
		
	}

}
