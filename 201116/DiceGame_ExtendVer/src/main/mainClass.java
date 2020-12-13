package main;

import cls.workClass;

public class mainClass {

	public static void main(String[] args) {
		int[] rArr;
		int[] uArr;
		int inputCoin;
		int resultUarr;
		int rResult, uResult;
		int resultCoin;
		
		workClass wc = new workClass();
		rArr = wc.random();
		inputCoin = wc.inputCoin();	//코인수입력
		uArr = wc.inputUser(); //유저가 두 주사위에 들어갈 숫자를 입력
		resultUarr = wc.uResult(uArr); //두 주사위 합 출력
		
		
		rResult = wc.rResult(rArr);
		uResult = wc.uResult(uArr);
		resultCoin = wc.resultPrint(rResult,uResult,rArr,uArr,inputCoin);
		
		System.out.println("배팅결과 코인수 : "+resultCoin);
	}

}
