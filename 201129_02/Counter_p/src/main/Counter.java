package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Counter extends JFrame implements ActionListener{
	JLabel lbl;
	JTextArea jta;
	JButton plus, minus, reset;
	int num = 0;
	
	public Counter() {
		
		super("카운터 프로그램");
		
		setLayout(null);
		
		
		lbl = new JLabel("COUNTER PROGRAM");
		lbl.setBounds(20, 30, 240, 30);
		lbl.setBackground(Color.white);
		add(lbl);
		
		jta = new JTextArea(num+"");
		jta.setBounds(20, 80, 240, 50);
		
		add(jta);
		
		plus = new JButton("+");
		plus.setBounds(20, 145, 110, 50);
		plus.addActionListener(this);
		add(plus);
		
		minus = new JButton("-");
		minus.setBounds(150, 145, 110, 50);
		minus.addActionListener(this);
		add(minus);
		
		reset = new JButton("reset");
		reset.setBounds(20, 210, 240, 40);
		reset.addActionListener(this);
		add(reset);
		
		setSize(300, 300);
		setLocation(100, 100);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == plus) {
			num++;
		}else if(e.getSource() == minus) {
			if(num > 0) {
				num--;
			}
		}else if(e.getSource() == reset) {
			num = 0;
		}
		
		jta.setText(num+"");
	}
	
	
}
