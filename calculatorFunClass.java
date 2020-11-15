package practice02;

import java.util.Scanner;
/*
public class calculatorFunClass {

	public static void main(String[] args) {
		

		//calculator function
		int num1, num2;
		String op;
		
		//숫자입력
		num1 = Integer.parseInt(inputNum("첫번째"));
		
		//연산자입력
		op = inputOper();
		
		//연산자에 맞는 결과
		num2 = Integer.parseInt(inputNum("두번째"));
		
		//출력
		resultPrint(num1, num2, op);
		
	}
	
	//숫자 입력
	static String inputNum(String str) {
		Scanner sc = new Scanner(System.in);
		boolean realNum = false;
		String oneNum;
		
		while(true) {
				System.out.println(str+"번째 숫자를 입력해주세요");
				oneNum = sc.next();
				
				for (int i = 0; i < oneNum.length(); i++) {
					int asc = (int)(oneNum.charAt(i));
					
					if(asc>47 && asc<58) {
						realNum = true;
						break;
					}
				}
				
				if(realNum == true) {
					break;
				}
				
				System.out.println("문자가 포함되어 있습니다. 다시");
		}
		
		return oneNum;
	}
	
	
	//연산자 입력
	static String inputOper() {
		Scanner sc = new Scanner(System.in);
		String op;
		while(true) {
			System.out.println("연산자를 입력하세요(+, -, *, /)");
			op = sc.next();
			
			if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
				break;
			}
		}
		return op;
	}
	
	//결과출력
	static void resultPrint(int n1, int n2, String oper) {
		int result = 0;
		
		switch(oper) {
			case "+" : 
				result = n1+n2;
			break;
			case "-" : 
				result = n1-n2;
			break;
			case "*" : 
				result = n1*n2;
			break;
			case "/" : 
				result = n1/n2;
			break;
		}
		
		System.out.println(n1 + oper + n2 + " = "+ result);
	}
	
}
		*/