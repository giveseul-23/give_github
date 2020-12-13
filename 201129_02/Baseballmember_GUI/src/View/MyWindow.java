package View;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow extends JFrame{

	public MyWindow() {
		
		add(new MainView(this));
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.white);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
