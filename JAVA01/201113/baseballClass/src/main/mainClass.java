package main;

import baseball.baseball;

public class mainClass {

	public static void main(String[] args) {

		baseball ball = new baseball();

		ball.init();
		ball.loop();
		ball.result();
		
	}
}
