package practice03;

import java.util.Arrays;
import java.util.Scanner;

public class baseballFunClass {

	public static void main(String[] args) {

		//베이스볼게임 - function
		int rArr[] = null;
		int uArr[] = null;
		int ball, strike;
		boolean resultgame = false;
		boolean replay = false;
		
		while(true) {
			//랜덤수 3개 - 같은숫자x
			rArr = random();
			System.out.println(Arrays.toString(rArr));
			
			//게임루프 - 10번
				//유저값 입력 - 같은숫자x, 판정(ball, strike)
			//uArr = inputUser();
			//System.out.println(Arrays.toString(uArr));//유저수 입력 배열
			resultgame = gameloop(rArr);
			
			//판정에따른 결과
			resultPrint(resultgame);
		
			//게임유무
			replay = replay();
			
			if(replay == true) {
				System.out.println("화이팅 하세요.");
				continue;
			}else if(replay == false) {
				System.out.println("안녕히가세요.");
				break;
			}
		}
	}
	
	static int[] random() {
		int[] rArr = new int[3];
		boolean[] swit = new boolean[10];
		
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;
		}
		
		int w = 0;
		while(w<rArr.length){
			int r = (int)(Math.random()*10);
			
			if(swit[r] == false) {
				swit[r] = true;
				rArr[w] = r + 1;
				w++;
			}
			
		}
		
		return rArr;
		
	}
	
	//게임루프 10번
	static boolean gameloop(int[] rArr) {
		boolean resultgame = false;
		int[] uArr;
		int ball, strike;
		int w = 0;
		while(w<10) {
			//유저수 입력
			uArr = inputUser();
			
			//랜덤과 유저 비교하여 ball, strike 판정
			ball = strike = 0;//초기화
			
			ball = ballResult(uArr, rArr);
			strike = strikeResult(uArr, rArr);
			
			//결과
			System.out.println(strike+"스트라이크, "+ball+"볼 입니다.");
			
			if(strike==3) {
				resultgame = true;
				break;
			}
			
			w++;
		}
		
		return resultgame;
	}
	
	//게임결과 출력
	static void resultPrint(boolean resultgame) {
		if(resultgame == true) {
			System.out.println("게임에서 승리하였습니다.");
		}else if(resultgame == false) {
			System.out.println("게임에서 실패하였습니다.");
		}
	}
	
	//게임유무 입력
	static boolean replay() {
		Scanner sc = new Scanner(System.in);
		boolean replay = false;
		
		System.out.print("게임을 다시 하시겠습니까?(y/n)");
		String inputreplay = sc.next();
		
		if(inputreplay.equals("y")) {
			replay = true;
		}else if(inputreplay.equals("n")) {
			replay = false;
		}
		
		return replay;
	}
	
	//유저값 입력
	static int[] inputUser() {
		Scanner sc =  new Scanner(System.in);
		int[] uArr = new int[3];
		
		while(true) {
			for (int i = 0; i < uArr.length; i++) {
				System.out.println((i+1)+"의 자리숫자를 입력하세요");
				uArr[i] = sc.nextInt();
			}
			
			if(uArr[0] != uArr[1] && uArr[0] != uArr[2] && uArr[1] != uArr[2]) {
				break;
			}
			
			System.out.println("같은숫자가 있습니다. 다시");
		}
		return uArr;
	}
	
	//ball
	static int ballResult(int[] rArr, int[]uArr) {
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
		static int strikeResult(int[] rArr, int[]uArr) {
			int strike = 0;
			for (int i = 0; i < uArr.length; i++) {
				if(uArr[i] == rArr[i]) {
					strike++;
				}
			}
			return strike;
		}
	
}
