package main;

import cls.ParentClass;
import cls2.ChildOneClass;
import cls3.ChildTwoClass;

public class mainClass {

	public static void main(String[] args) {
		
		//satic : 정적영역
		
		/*
			stack - 지역변수, 데이터를 임시 저장하고 잠깐 사용
			heap - 실제로 데이터가 저장되는 공간, 멤버변수
			static - 정적영역, 데이터공간을 공유함
			Sys
		*/
		
		ChildOneClass cc = new ChildOneClass();
		cc.method();
		cc.method();
		cc.method();
		
		ChildOneClass cc_c = new ChildOneClass();
		cc_c.method(); //다른 인스턴스를 생성하더라도 static변수의 경우 같은 데이터 공간을 사용하기 때문에 값이 고정되어 있다
		//그래서 위에 구문에서 증가한 값이 다른 인스턴스를 생성하더라도 그대로 유지된다.
		
		
		//static 메서드를 호출할때는 따로 인스턴스를 생성하지 않는다.
		ChildOneClass.st_method();
		
		//리턴값 받는 static 
		ChildOneClass coc = ChildOneClass.return_method();
	}
	
}
