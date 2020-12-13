package game;

import java.util.Scanner;

import dice.Dice;

public class Game {
	Scanner sc = new Scanner(System.in);
	
	/*
		2, 12 : 제시할 수없음
		3, 11 : 18 배
		4, 10 : 12 배
		5, 9 : 9 배
		6, 8 : 7 배
		7 : 6 배
	*/
	
	private int coin;
	private int batting;
	private int inputNum;
	
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	
	public Game() {
		coin = 20;
	}
	
	public void init() {
		dice1.diceRand();
		dice2.diceRand();
		
		System.out.println("주사위1 : " + dice1.getNumber());
		System.out.println("주사위2 : " + dice2.getNumber());
		
	}
	
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("batting money = ");
			batting = sc.nextInt();
			
			System.out.println("주사위의 합 = ");
			inputNum = sc.nextInt();
			if(inputNum != 2 && inputNum != 12) {
				coin = coin - batting;
				
				break;
			}
			
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void finding() {
		int dnum1 = dice1.getNumber();
		int dnum2 = dice2.getNumber();
		
		int diceSum = dnum1 + dnum2;
		
		if(inputNum == diceSum) {
			if(diceSum == 3 || diceSum == 11) {
				batting = batting * 18;
			}else if(diceSum == 4 || diceSum == 10) {
				batting = batting * 12;
			}else if(diceSum == 5 || diceSum == 9) {
				batting = batting * 9;
			}else if(diceSum == 6 || diceSum == 8) {
				batting = batting * 7;
			}else if(diceSum == 7) {
				batting = batting * 6;
			}
			
			coin = coin + batting;
			
			System.out.println("축하합니다.");
			
			
		}else {
			System.out.println("아쉽습니다. 다시 도전하세요!");
		}
	}
	
	public void result() {
		System.out.println("주사위1 : "+dice1.getNumber() + ", 주사위2 : "+dice2.getNumber());
		
		System.out.println("합계 : " + (dice1.getNumber() + dice2.getNumber()));
		System.out.println("현재급액 : " + coin);
	}
	
	public void gameplay() {
		
		while(true) {
			init();
			userInput();
			finding();
			result();
			
			System.out.print("다시 도전하시겠습니까 (y/n) = ");
			String yes = sc.next();
			
			if(yes.equals("n") || yes.equals("N")) {
				System.out.print("안녕히가십시오.");
				break;
			}
			
			System.out.println("행운을 빕니다~");
		}
	}
	
}
