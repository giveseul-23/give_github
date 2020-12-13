package cls;

import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class workClass {
	//코인 : 20개
	int rResult, uResult;
	
	
	//배팅할 코인수 입력
	public int inputCoin() {
		Scanner sc = new Scanner(System.in);
		int coninCount;
		while(true) {
			System.out.print("배팅할 코인 수는? : ");
			coninCount = sc.nextInt();
			
			if(coninCount>0 && coninCount<21) {
				break;
			}
			
			System.out.println("가진 코인 수와 맞지 않습니다 다시입력하세요");
		}
		
		return coninCount;
		
	}
	
	//유저 두 주사위 합 입력
	public int[] inputUser() {
		Scanner sc = new Scanner(System.in);
		int uArr[] = new int[2];
		
		while(true) {
			System.out.print("두 주사위의 합은?");
			
			for (int i = 0; i < uArr.length; i++) {
				System.out.print((i+1)+"의 자리 주사위 숫자는 ");
				uArr[i] = sc.nextInt();
			}
			
			
			if((uArr[0]!=1 && uArr[1]!=1) || (uArr[0]!=6 && uArr[1]!=6)){ 
				break;
			}
			
			System.out.println("제시할 수 없습니다. 다시입력하세요");
		}
		
		return uArr;
	}
	
	//주사위(x2) 랜덤값 받기
	public int[] random() {
		int rArr[] = new int[2];
		for (int i = 0; i < rArr.length; i++) {
			rArr[i] = (int)(Math.random()*5+1); // 1~6
		}
		System.out.print("주사위 번호는 "+Arrays.toString(rArr));
			
		return rArr;
	}
		
	//주사위 합
	public int rResult(int[] rArr) {
		int result = 0;
		
		for (int i = 0; i < rArr.length; i++) {
			result = result+rArr[i];
		}
		
		return result;
	}
	
	//유저 합
	public int uResult(int[] uArr) {
		int result = 0;
		
		for (int i = 0; i < uArr.length; i++) {
			result = result+uArr[i];
		}
		
		return result;
	}
	
	//유저합과 주사위 합 판정하여 결과출력
	public int resultPrint(int rResult, int uResult, int[] rArr, int[]uArr, int coin) {
		int resultCoin = 0;
		
		if(rResult == uResult) {
			if((rResult = uResult)==3 || (rResult = uResult)== 11) {
				resultCoin = coin*18;
			}else if((rResult = uResult)==4 || (rResult = uResult)== 10) {
				resultCoin = coin*12;
			}else if((rResult = uResult)==5 || (rResult = uResult)== 9) {
				resultCoin = coin*9;
			}else if((rResult = uResult)==6 || (rResult = uResult)== 8) {
				resultCoin = coin*7;
			}else if((rResult = uResult)==7) {
				resultCoin = coin*6;
			}
		}
		
		return resultCoin;
	}
}
