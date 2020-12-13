package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {
	
	public WindowTest() {
		
		//setLayout(new FlowLayout());
		//setLayout(new GridLayout(3, 1)); //3행(가) 1열(세)의 레이아웃
		setLayout(null); //레이아웃 사용하지 않겠다는 뜻
		
		//Label
		Label label = new Label();
		label.setText("Label");
		label.setBounds(150, 30, 50, 30);//직접 위치를 정해줌(x, y, width, height)
		add(label);
		
		Label label1 = new Label("레이블입니다.");
		label1.setBackground(Color.black);
		label1.setForeground(Color.white);
		label1.setBounds(150, 80, 80, 50);
		add(label1);
		
		Button button = new Button();
		button.setLabel("버튼");
		button.setBackground(Color.BLUE);
		button.setForeground(Color.white);
		button.setBounds(150, 150, 200, 200);
		add(button);
		
		
		//setSize(640, 480);
		//setLocation(0, 0);
		setBounds(0, 0, 800, 600);	//setSize + setLocation
		
		setVisible(true);
		
		addWindowListener(this);
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
