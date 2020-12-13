package baseballclass;

import java.util.Arrays;
import java.util.Scanner;

public class baseballclass {
	
	int rArr[];
	int uArr[];
	int ball, strike;
	boolean clear;
	
	//초기화
	public void init(){
		rArr = null;
		uArr = null;
		clear = false;
	}
	
	//랜덤수 기능
	public int[] random(){
		boolean swit[] = new boolean[10];
		int w = 0;
		int rArr[] = new int[3];
		
		while(w < rArr.length) {
			int r = (int)(Math.random()*10);
			
			if(swit[r] == false) {
				swit[r] = true;
				rArr[w] = r + 1;
				
				w++;
			}
		}
		
		System.out.println("랜덤 : "+Arrays.toString(rArr));
		
		return rArr;
	}
	
	//게임루프
	public boolean gameloop(int[] rArr) {
		int loop = 0;
		boolean clear = false;
		
		while(loop<10) {
			
			int ball = strike = 0; //초기화
			//유저수 입력
			uArr = userInput();
			
			//판정
			ball = ballResult(uArr, rArr);
			strike = strikeResult(uArr, rArr);
			
			//판정결과 
			System.out.println(strike+"스트라이크, "+ball+"볼입니다.");
			
			if(strike == 3) {
				clear = true;
				break;
			}
			
			loop++;
		}
		return clear;
	}
	
	//유저값
	public int[] userInput() {
		Scanner sc = new Scanner(System.in);
		
		int uNum[] = new int[3];
		
		while(true) {
			int w = 0;
			while(w<uNum.length) {
				System.out.print((w+1)+"의 자리 숫자를 입력하세요 : ");
				uNum[w] = sc.nextInt();
				w++;
			}
			
			if(uNum[0] != uNum[1] && uNum[0] != uNum[2] && uNum[1] != uNum[2]) {
				break;
			}
			
			System.out.println("숫자가 중복됩니다. 다시 입력하세요");
		}		
		
		return uNum;
	}
	
	//판정 - ball, strike
	
	//ball
	public int ballResult(int[] rArr, int[] uArr) {
		int ball = 0;
		
		for (int i = 0; i < uArr.length; i++) {
			for (int j = 0; j < rArr.length; j++) {
				if(uArr[i] == rArr[j] && i != j) {
					ball++;
				}
			}
		}
		return ball;
	}
	
	//strike
	public int strikeResult(int[] rArr, int[] uArr) {
		int strike = 0;
		
		for (int i = 0; i < uArr.length; i++) {
			if(uArr[i] == rArr[i]) {
					strike++;
			}
		}
		return strike;
	}
	
	//승패여부 결과 출력
	public void gameResult(boolean clear) {
		if(clear == true) {
			System.out.println("게임에서 승리하였습니다.");
		}else if(clear == false) {
			System.out.println("게임에서 실패하였습니다.");
		}
	}
	
	
	//게임리플레이 유무
	public boolean replaygame() {
		Scanner sc = new Scanner(System.in);
		boolean gtf = false;
		
		System.out.println("게임을 다시 진행하시겠습니까?(y/n)");
		String replay = sc.next();
		
		if(replay.equals("y")) {
			gtf = true;
		}else if(replay.equals("n")) {
			gtf=false;
		}
		
		return gtf;
	}
	
}
