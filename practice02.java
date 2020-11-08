package work07_01;

import java.util.Scanner;

public class practice02 {

	public static void main(String[] args) {
		
		//문자열 자료형으로 입력값 받을 변수
		String num;
		int result = 0; //result가 값이 0이면 정수로 표현됨
		
		boolean b = false;
//		int w = 0;
		
		//유저값이 소수인지 정수인지 판단
		Scanner sc = new Scanner(System.in);

		
		
		//int len = num.length();
		
		//유저값이 정수가 아니라면 계속 입력값을 받는다
		
				//유저값 입력
				System.out.println("수를 입력하세요");
				num = sc.next();
				
				//소수인지 정수인지 판단
				for (int i = 0; i < num.length(); i++) {
					
					char c = num.charAt(i);			
					int asc = (int)c;//유저값 내 문자를 아스키숫자로 변경
					
					if((i==0 && c=='.') || (i == num.length()-1 && c=='.')) {
						//처음과 끝에 '.'이 포함되어있거나 문자가 포함되어 있을 때
						result = 1;
						break;
					}else if(c=='.') {
						//중간자리에 '.'가 포함되어 있을 때
						result = 2;
						break;
					}
					
				}
			//break;	
				
		
		
		//결과출력
		switch(result) {
			case 0 :
				System.out.println("정수입니다.");
				break;
			case 1 :
				System.out.println("문자가 포함되어 있습니다.");
				break;
			case 2 :
				System.out.println("소수입니다.");
				break;
		}
		
	}

}
