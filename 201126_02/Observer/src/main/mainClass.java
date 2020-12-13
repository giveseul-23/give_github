package main;

import cls.MyClass;
import observer.ObserverBB;
import observer.observerAA;

public class mainClass {

	public static void main(String[] args) {
		
		/*
		
			Observer : 	감시, 정찰
						감시자 패턴
						특정 class를 감시
			
		
		*/
		
		MyClass cls = new MyClass();
		
		//감시자 두명 추가
		cls.addObserver(new observerAA());
		cls.addObserver(new ObserverBB());
		
		cls.setId("abc123");
		cls.setPassword("aabbccddPassword");
		
		cls.notifyObservers("ID : "+cls.getId() + ", PASSWORD : "+cls.getPassword());
	}

}
