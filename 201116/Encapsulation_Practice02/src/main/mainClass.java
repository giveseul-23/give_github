package main;

import cls.workClass;

public class mainClass {

	public static void main(String[] args) {
		
		workClass t = new workClass();
		
		t.setChannel(10);
		System.out.println("CH : "+t.getChannel());
		t.setChannel(20);
		System.out.println("CH : "+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH : "+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH : "+t.getChannel());
		
	}

}
