package main;

import cls.workClass;

public class mainClass {
	public static void main(String[] args) {
		
		workClass wc = new workClass();
		
		wc.name = "홍길동";
		wc.ban = 1;
		wc.no = 1;
		wc.kor = 100;
		wc.eng = 60;
		wc.math = 76;
		
		System.out.println("이름:"+wc.name);
		System.out.println("총점:"+wc.getTotal(wc.kor, wc.eng, wc.math));
		System.out.println("평균:"+wc.getAverage());
	}
}
