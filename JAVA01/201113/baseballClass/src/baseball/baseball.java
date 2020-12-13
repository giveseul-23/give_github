package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class baseball {
	int r_num[];	//랜덤수 배열
	int u_num[];	//유저수 배열
	boolean clear;	//결과 판정을 위한 t/f 변수
	int strike, ball;	
	int count; 	// 횟수
	
	
	//초기화
	public void init() {
		r_num = new int[3]; //배열의 갯수를 정해줌
		u_num = new int[3];
		clear = false;
		count = 1;	//카운트는 0부터 시작되면 x
		
		random();	//랜덤은 바로 호출해줌
	}
	
	//랜덤수 
	public void random() {
		boolean swit[] = new boolean[10];	//같은 수가 나오지 않도록 스위치10개를 만들어줌
		int r,w;
		
		for (int i = 0; i < swit.length; i++) swit[i] = false; //swit all off
		w = 0;
		
		while(w<3) {
			r = (int)(Math.random()*10);	//0~9까지 랜덤을 돌려줌
			if(swit[r] == false) {	//스위치를 다 off시켜줬으니 처음에는 구문에 바로 들어감
				swit[r] = true;	//false가 아니라면 스위치를 on시켜줌
				r_num[w] = r + 1; //배열의 순서에 맞춰서 랜덤값+1(범위 : 1~10)을 넣어줌
			}
			w++;
		}
		System.out.println(Arrays.toString(r_num));//랜덤수 배열 전체를 출력해줌
	}
	
	//유저입력
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < u_num.length; i++) {
			System.out.print((i+1)+"번째 숫자는 = ");
			u_num[i] = sc.nextInt();	
		}
	}
	
	//판정 strike, ball
	public boolean finding() {
		strike = ball = 0; //초기화
		
		//strike ball 
		for (int i = 0; i < r_num.length; i++) {
			for (int j = 0; j < u_num.length; j++) {
				if(r_num[i] == u_num[j] && i != j) {
					//값은 같으나 자리가 다르면 
					ball++;
				}
			}
		}
		
		for (int i = 0; i < r_num.length; i++) {
			if(r_num[i] == u_num[i]) {
				//값도 같고 자리도 같으면
				strike++;
			}
		}
		
		if(strike>2) {
			//스트라이크가 2이상이면 boolean 값을 true로 넘겨줌
			return true;
		}
		
		//message
		System.out.println(strike + "스트라이크, " + ball + "볼 입니다.");
		
		//스트라이크가 2이상 되지 못했다면 boolean 값을 false로 넘겨줌
		return false;
	} 
	
	//루프
	public void loop() {
		
		int w = 0;
		
		while(w<10) {
			
			userInput(); //유저값 입력
			
			clear = finding(); //finding으로 clear값 넘겨받음
			
			if(clear==true) {
				//3스트라이크면 구문 탈출함
				break;
			}
			
			w++;
			count++;
		}
		
	}
	
	//결과
	public void result() {
		if(clear) {
			System.out.println(count+"회만에");
			System.out.println("Game Clear!");
		}else {
			System.out.println("Game Over~");
		}
	}
	
}
