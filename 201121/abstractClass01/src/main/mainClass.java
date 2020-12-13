package main;

import cls.AbstractClass;
import cls.NormalClass;

public class mainClass {

	public static void main(String[] args) {
		  
		
		/*
		
			abstract : 추상 - 처음에 결정하지 않고 나중에 결정하는 경우
					 	완전체는 아닌 선언만 되어있는 매소드를 포함하고 있는 클래스
					 	
					 	추상메서드 + 일반메서드 + 변수 = 추상클래스
					 	
					 	생성은 불가능하다. 상속 후 추상메서드를 작성한 후에 생성이 가능
					 	instance 로 생성은 가능하다.
					 	
			abstract class{
				void method(){
				
				}
				abstract void func();
			}
		
		*/
		
		// AbstractClass acls = new AbstractClass(); -> 오류, 생성불가
		
		NormalClass nc = new NormalClass();
		nc.method();
		nc.abstractMethod();
		
		
		AbstractClass ac = new NormalClass();
		ac.method();
		ac.abstractMethod();
		
		//상속받지 않고 바로 overRiding하는 것도 가능하다
		AbstractClass ac2 = new AbstractClass() {
			
			@Override
			public void abstractMethod() {
				System.out.println("AbstractClass abstractMethod()");
			}
		};
		
		ac2.method();
		
	}

}
