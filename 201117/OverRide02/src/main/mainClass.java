package main;

import childone.ChildOne;
import childtwo.ChildTwo;
import parent.Parent;

public class mainClass {

	public static void main(String[] args) {
		
		/*
		//10명
		ChildOne one = new ChildOne();
		ChildTwo two = new ChildTwo();
		*/
		
		/*
		
		Parent pone = new ChildOne();
		Parent ptwo = new ChildTwo();
		
		//Parent에서 같이 관리하다가 ChildOne의 func를 꺼내주고 싶을 때 cast(형변환)을 통해서 접근이 가능하다.
			ChildOne cone = (ChildOne)pone;
			cone.func();
		
		*/
		
		//Object 다 사용가능!
		Object obj = new ChildOne();
		Object obj1 = new ChildTwo();
		
		ChildOne one = (ChildOne)obj;
		one.func();
		
		ChildTwo two = (ChildTwo)obj1;
		two.func2();
		
		/*
		Parent pArr[] = new Parent[10];
		pArr[0] = new ChildOne();
		pArr[1] = new ChildTwo();
		pArr[2] = new ChildTwo();
		pArr[3] = new ChildTwo();
		pArr[4] = new ChildOne();
		pArr[5] = new ChildOne();
		pArr[6] = new ChildTwo();
		pArr[7] = new ChildTwo();
		pArr[8] = new ChildTwo();
		pArr[9] = new ChildOne();
		
		for (Parent p : pArr) {
			p.method();
		}
		
		*/
		
	}

}
