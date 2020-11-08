package work07_01;

import java.util.Scanner;

public class practice01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//입력값에서 숫자, 문자 구분하여 출력하기
		
		String sNum; //문자열 입력값 변수
		boolean b= false; //논리형 변수(문자, 숫자 구분 후 구문 탈출)
		
		//입력값 받기
		System.out.println("값을 입력하세요");
		sNum = sc.next();
		

		
		//받은 입력값으로 숫자와 문자 구분하기
		
		//입력값을 배열로 만들고 해당 배열의 루프를 통해 문자와 숫자를 구분
		for (int i = 0; i < sNum.length(); i++) {
			
			//문자로 받은 유저값을 배열로 변경하여 아스키코드 값(문자를 숫자로 표현) 받기
			char c = sNum.charAt(i);
			int asc = (int)c;//숫자로 변경됨
			
			//변경된 숫자를 아스키코드 표를 통해서 문자를 구분함
			if(asc<=47 || asc>=58) {
				//해당 값이 참이 되면 논리형 변수는 true가되고 for문을 탈출함
				b = true;
				break;
			}
		}
		
		//for문을 탈출한 후 b값에 의해 출력값이 결정됨
		if(b == true) {
			System.out.println("문자입니다.");
		}else {
			System.out.println("숫자입니다.");
		}
		
	

	}

}
