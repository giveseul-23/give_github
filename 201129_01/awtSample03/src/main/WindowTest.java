package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener, ActionListener {
	
	Label label;
	Button button1, button2;
	
	public WindowTest() {

		setLayout(null);
		
		label = new Label("label");
		label.setBounds(100, 100, 300, 30);
		label.setBackground(Color.LIGHT_GRAY);
		add(label);

		button1 = new Button();
		button1.setLabel("one button");
		button1.setBounds(100, 160, 150, 30);
		button1.addActionListener(this);
		add(button1);
		
		button2 = new Button();
		button2.setLabel("two button");
		button2.setBounds(300, 160, 150, 30);
		button2.addActionListener(this);
		add(button2);
		
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		addWindowListener(this);
		
		
	}
	
	
	//버튼클릭시 -> action을 취함
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("버튼 클릭!");
		//JOptionPane.showMessageDialog(null, "버튼 클릭!");
		
		Button btn = (Button)e.getSource();
		String btnTitle = btn.getLabel();
		
		if(btnTitle.equals("one button")) {
		//	JOptionPane.showMessageDialog(null, "one 버튼 클릭!");
			label.setText("one btn click!");
		}else if(btnTitle.equals("two button")) {
		//	JOptionPane.showMessageDialog(null, "two 버튼 클릭!");
			label.setText("two btn click!");
		}
		
		
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
