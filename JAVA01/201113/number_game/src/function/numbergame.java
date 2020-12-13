package function;

import java.util.Scanner;

public class numbergame {
		/*
				숫자빼기게임
			
				랜덤 : 15 ~ 100 > 1개를 받음
				유저입력
				숫자범위 : 1~5
				
				~ 계속 play ~
				
				점점 빼기하다가 0과같거나 작으면 게임에서 진다
				
				+replay
		 */
	
	int rNum, uNum;
	boolean clear;
	
	
	//초기화
	public void init() {
		clear = false;
		random();
	}		
	
	//게임루프 여부 입력
	public boolean loop() {
		boolean loop = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("게임을 다시 시작하시겠습니까?(y/n)");
		String tf = sc.next();
		if(tf.equals("y")) {
			loop = true;
		}else if(tf.equals("n")) {
			loop = false;
		}
		
		return loop;
	}
	
	//게임루프 돌리기
	public void gameloop(boolean b) {
		while(true) {
			if(b==true) {
				System.out.println("화이팅하세요!");
				random();
				game_result();
				resultPrint();
			}
			
			if(b == false) {
				System.out.println("안녕히가세요~");
				break;
			}
		}
	}
	
	//랜덤 출력
	public void random() {
		rNum = (int)(Math.random()*85+15);
		System.out.println(rNum);
		
	}
	
	//유저값 입력
	public int userInput() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("빼기할 값을 입력하세요.(범위 : 1~5)");
			uNum = sc.nextInt();
			
			if(uNum>0 && uNum<6) {
				break;
				
			}
		System.out.println("범위를 벗어났습니다. 다시 입력하세요");
		}
		
		return uNum;
	}
	
	//빼기 기능
	public void game_result() {
		boolean b = true;
		int uNum = userInput();
		int result = rNum - uNum;
		System.out.println(result);
		
		while(true) {
			uNum = userInput();
			
			result = result - uNum;
			System.out.println(result);
			if(result<=0) {
				b = false;
				break;
			}
		}
		
	}
	
	//게임판정
	public void resultPrint() {
		if(clear == false) {
			System.out.println("game over! you looser!");
		}
	}
	
	
	
	

}
