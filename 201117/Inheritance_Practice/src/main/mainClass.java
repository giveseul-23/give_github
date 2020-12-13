package main;

import childone.ChildOne;
import childtwo.ChildTwo;
import parent.Parent;

public class mainClass {

	public static void main(String[] args) {
		
		/*
			instanceOf
			: instance를 구별하기 위한 키워드
		*/
		
		Parent arrPar[] = new Parent[3];
		
		arrPar[0] = new ChildOne();
		arrPar[1] = new ChildTwo();
		arrPar[2] = new ChildTwo();
		
		
		for (int i = 0; i < arrPar.length; i++) {
			arrPar[i].method();	//오버라이드된 메서드
			
			if(arrPar[i] instanceof ChildOne) {
				//instanceof 연산자는 생성자의 prototype 속성이 
				//객체의 프로토타입 체인 "어딘가 존재"하는지 판별합니다.
				
				//차일드원으로 생성되면 구문 안으로 들어옴
				((ChildOne)arrPar[i]).ChildOneMethod();
			}else if(arrPar[i] instanceof ChildTwo) {
				//차일드투로 생성되면 구문 안으로 들어옴
				ChildTwo t = (ChildTwo)arrPar[i];
				t.ChildTwoMethod();
			}
		}
		
		//ChildOne one = (ChildOne)arrPar[0];
		//one.ChildOneMethod();
		
		if(arrPar[0] instanceof ChildTwo) {
			System.out.println("arrPar[0]는 ChildOne로 생성되었음");
		}
		
	}

}
