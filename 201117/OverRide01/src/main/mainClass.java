package main;

import child.ChildClass;
import childone.ChildOneClass;
import parant.ParantClass;

public class mainClass {

	public static void main(String[] args) {
			/*
			
				Over Ride
				: 상속 받은 후에 자식클래스에서 상속받은 함수를 고쳐 기입함을 의미
				
				상속받은 함수와 prototype(사양)이 같아야 한다.
				
				public void func(int i){
					//prototype : 매개변수 int, 리턴값 없음
				}
				public double func(String s){
					//prototype : 매개변수 String, 리턴값 double
				}
				
			
		
		//ChildClass cc = new ChildClass();
		//cc.parant_method(); //ChildClass의 over ride한 것이 출력됨
		
		//ParantClass pc = new ChildClass();
		
		ChildClass childArr[] = new ChildClass[5];
		ChildOneClass childoneArr[] = new ChildOneClass[3];
		
		childArr[0] = new ChildClass();
		childArr[1] = new ChildClass();
		childArr[2] = new ChildClass();
		childoneArr[0] = new ChildOneClass();
		childoneArr[1] = new ChildOneClass();
		childoneArr[2] = new ChildOneClass();
		
		ParantClass pcArr[] = new ParantClass[8];	//인스턴스를 하나로 묶을 수 있다.
		pcArr[0] = new ChildClass();
		pcArr[1] = new ChildOneClass();
		pcArr[2] = new ChildOneClass();
		pcArr[3] = new ChildClass();
		*/
		
		//override한 것만 아래처럼 사용할수있다.
		ParantClass pc = new ChildClass();
		//pointer는 ParantClass, 생성한 데이터는 ChildClass
		//관리는 ParantClass, 처리는 ChildClass
		//-> 관리한다는 의미가 하나로 묶기도 하지만
		//ParantClass에서는 형식은 유지하고 ChildClass에서 형식의 내용만 변경하면서 처리함
		pc.parant_method();
	}

}
