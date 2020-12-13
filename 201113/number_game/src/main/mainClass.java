package main;

import function.numbergame;

public class mainClass {

	public static void main(String[] args) {

		numbergame ng = new numbergame();
		boolean gloop;
		
		ng.init();
		ng.game_result();
		ng.resultPrint();
		
		gloop = ng.loop();
		ng.gameloop(gloop);
		
	}

}
