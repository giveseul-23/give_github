package calculator_teacher;

import java.util.Scanner;

public class calculator2 {
	
	int num1, num2;//멤버변수
	String oper;
	int result;
	
	
	public int inputNumber(String str) {
		Scanner sc = new Scanner(System.in);
		String snum;
		
		
		while(true) {
			System.out.print(str + " number = ");
			snum = sc.next();
			
			boolean ok = true;
			for (int i = 0; i < snum.length(); i++) {
				char c = snum.charAt(i);
				int asc = (int)c;
				if(asc < 48 || asc > 57) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오");
					ok = false;
					break;
				}
			}
			if(ok == true) {
				break;
			}			
		}	
		
		return Integer.parseInt(snum);		
	}

	public void  inputOperator() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("연산자(+, -, *, /) = ");
			oper = sc.next();			
			if(!oper.equals("+") && !oper.equals("-") 
					&& !oper.equals("*") && !oper.equals("/")) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오");
				continue;
			}
			break;
		}
		
	}

	public void numberProc() {
		
		switch( oper ) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;		
		}
	}
	
	public void resultPrint(){
		
		num1 = inputNumber("첫번째"); //첫번째 입력, 판정
		inputOperator();//연산자 입력, 판정
		num2 = inputNumber("두번째");	//두번째 입력, 판정
		numberProc();//연산처리
		
		System.out.println(num1 + " " + oper + " " + num2 + " = " + result);
		
	}
	
	
	
}
