package cls;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Field;

import javax.swing.JTextField;

public class WindowClass extends Frame implements WindowListener, ActionListener{
	
	Label lbl1, lbl2;
	Button btn1, btn2, btn3;
	int num;
	
	public WindowClass() {
		
		setLayout(null);
		
		lbl1 = new Label("COUNTER");
		lbl1.setBounds(100, 50, 300, 50);
		lbl1.setBackground(Color.green);
		add(lbl1);
		
		lbl2 = new Label(num + "");
		lbl2.setBounds(100, 150, 300, 50);
		lbl2.setBackground(Color.cyan);
		add(lbl2);
		
		btn1 = new Button("+");
		btn1.setBounds(100, 300, 120, 120);
		btn1.setBackground(Color.red);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new Button("-");
		btn2.setBounds(280, 300, 120, 120);
		btn2.setBackground(Color.blue);
		btn2.addActionListener(this);
		add(btn2);
		
		btn3 = new Button("reset");
		btn3.setBounds(100, 500, 300, 50);
		btn3.setBackground(Color.yellow);
		btn3.addActionListener(this);
		add(btn3);
		
		setSize(500, 700);
		setLocation(0, 0);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button button = (Button)e.getSource();
		String btnTitle = button.getLabel();
		
		if(btnTitle.equals("+")) {
			num++;
			//lbl2.setText("" + num);
		}else if(btnTitle.equals("-")) {
			if(num > 0) {
				num--;
			}
			//lbl2.setText("" + num);
		}else if(btnTitle.equals("reset")) {
			num = 0;
		}
		
		
		lbl2.setText("" + num);
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



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}






}
