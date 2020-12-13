package main;

import javax.swing.JFrame;

public class WindowTestSwing extends JFrame{
	
	public WindowTestSwing() {
		
		setSize(1024, 768);
		setLocation(0, 0);
		setVisible(true);
		
		//아래 구문 작성시 오버라이드도 windowristner도 안해줘도 된다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
