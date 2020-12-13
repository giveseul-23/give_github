package main;

import cls.MyClass;
import cls.Pencil;
import cls.WriterClass;
import cls.ballpen;
import inter.Myinterface;
import inter.WriteMode;

public class mainClass {
	public static void main(String[] args) {
		/*
		
			abstract class : 추상메서드 + 일반메서드
			
			interface : 메서드가 선언만 되어있다. - 추상메서드로만 이뤄져 있는것을 인터페이스라 한다.
						생성은 불가능하다. 다만 상속 후에 정의를 한 후에 생성이 가능
						변수선언이 불가능
						다중상속이 가능하다(다중상속 : 부모가 여러명에 자식 한 명)
						
			목적 : 메서드만 선언해서 설계가능, 한 눈에 파악가능
		*/
		
		MyClass mycls = new MyClass();
		mycls.method();
		mycls.func();
		
		Myinterface myint = new MyClass();
		//인터페이스 부모				myclass가 자식
		myint.method();
		myint.func();
		
		//바로 작성도 가능
		Myinterface myinter = new Myinterface() {
			
			@Override
			public void method() {
			}
			
			@Override
			public void func() {
			}
		};
		
		/*
		WriterClass wc = new WriterClass();
		
		wc.writee_method(new Pencil());
		wc.writee_method(new ballpen());
		*/
		
		WriterClass wc = new WriterClass();
		WriteMode mode[] = new WriteMode[5];
		
		mode[0] = new Pencil();
		mode[1] = new ballpen();
		mode[2] = new ballpen();
		mode[3] = new Pencil();
		mode[4] = new Pencil();
		
		for (int i = 0; i < mode.length; i++) {
			wc.writee_method(mode[i]);
		}
	}
}
