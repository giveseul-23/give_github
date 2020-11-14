package practice01;

import java.util.Scanner;

public class calculatorClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//절차지향 - 계산기
		
		String sNum1, sNum2;
		String op;
		
		//숫자1 입력
		boolean b = false;
		while(true) {
			System.out.println("첫번째 숫자를 입력해주세요");
			sNum1 = sc.next();
				for (int i = 0; i < sNum1.length(); i++) {
					
					int asc = (int)sNum1.charAt(i);
					
					if(asc>47 && asc<58) {
						b = true;
						break;
					}
					
				}
				
				System.out.println("문자가 포함되어 있습니다.");
				
			if(b==true) {
				break;
			}
		}
		
		//연산자 입력
		while(true) {
			System.out.println("연산자를 입력하세요.(, -, *, /)");
			op = sc.next();
			
			if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
				break;
			}
			
			System.out.println("지원하지 않는 연산자입니다.");
		}
		
		
		//숫자2 입력
		while(true) {
			System.out.println("첫번째 숫자를 입력해주세요");
			sNum2 = sc.next();
				for (int i = 0; i < sNum2.length(); i++) {
					
					int asc = (int)sNum2.charAt(i);
					
					if(asc>47 && asc<58) {
						b = true;
						break;
					}
					
				}
				
				System.out.println("문자가 포함되어 있습니다.");
				
			if(b==true) {
				break;
			}
		}
		
		int result = 0;
		
		int num1 = Integer.parseInt(sNum1);
		int num2 = Integer.parseInt(sNum2);
		
		
		//판정
		switch(op) {
			case "+" : 
				result = num1 + num2;
				break;
			case "-" : 
				result = num1 - num2;
				break;
			case "*" : 
				result = num1 * num2;
				break;
			case "/" : 
				result = num1 / num2;
				break;
		}
		
		System.out.println(num1+op+num2+"="+result);
		
		}
	}



