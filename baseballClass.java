package practice01;

import java.util.Arrays;
import java.util.Scanner;

public class baseballClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//베이스볼게임
		
		//변수
		int random[] = new int[3];
		int user[] = new int[3];
		boolean swit[] = new boolean[10];
		
		int strike, ball;
		
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;
		}
		
		while(true){
				//랜덤수 입력받기 - 같은숫자x, 3개
				int w1 = 0;
				int r;
				while(w1<random.length) {
					r = (int)(Math.random()*10); //범위 : 0 ~ 9
					
					if(swit[r] == false) {
						swit[r] = true;
						random[w1] = r+1;
						w1++;
					}
					
				}
				System.out.println(Arrays.toString(random));
				
				//게임루프 - 10번
				int w=0;
				boolean gameloop = false;
				while(w<10) {
						//유저수 입력받기 - 같은숫자 X, 3개
						while(true) {
							for (int i = 0; i < user.length; i++) {
								System.out.println((i+1)+"의 자리 숫자를 입력하세요");
								user[i] = sc.nextInt();
							}
							
							if(user[0] != user[1] && user[0] != user[2] && user[1] != user[2]) {
								break;
							}
							
							System.out.println("반복되는 숫자가 있습니다. 다시 입력하세요.");
						}
						
						strike = ball = 0; // 여기다가 초기화를 해줘야 누적이 되지 않는다.
						
						//판정 - 유저수와 랜덤수 비교하여 ball, strike
						for (int i = 0; i < random.length; i++) {
							for (int j = 0; j < user.length; j++) {
								if(random[i]==user[j] && i != j) {
									ball++;
								}
							}
						}
						
						for (int i = 0; i < random.length; i++) {
							if(random[i] == user[i]) {
								strike++;
							}
						}
						
						
						
						if(strike>2) {
							gameloop = true;
							break;
						}
						
						//판정결과 
						System.out.println(strike+"스트라이크, "+ball+"볼 입니다.");
						
						w++;
				}
				
				//결과출력
				if(gameloop == true) {
					System.out.println("YOU WIN!");
				}else {
					System.out.println("GAME OVER~");
				}
				
				
				System.out.println("게임을 다시 시작하시겠습니까(y/n)");
				String u_answer = sc.next();
				
				if(u_answer.equals("y")) {
					System.out.println("화이팅 하세요!");
					continue;
				}else if(u_answer.equals("n")){
					System.out.println("안녕히 가세요~");
					break;
				}
				
		}
		
		
		
	}

 }
