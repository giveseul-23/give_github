package random;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowTest2 extends JFrame{
	
	JTextField txtf;
	JButton btn1, btn2;
	String str = "";
	RandomClickEvent rce;
	
	public WindowTest2() {
		
		setLayout(null);
		
		JPanel jp = new JPanel();
		
		txtf = new JTextField(20);
		txtf.setText("버튼의 갯수(1~9)");
		txtf.setBounds(20, 20, 200, 50);
		txtf.setHorizontalAlignment(JTextField.CENTER);
		add(txtf);
		
		btn1 = new JButton("set");
		btn1.setBounds(15, 100, 95, 80);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(str != null) {
					str = txtf.getText();
					//System.out.print(str);
					
				}
			}
			
		});
		add(btn1);
		
		btn2 = new JButton("create");
		btn2.setBounds(120, 100, 95, 80);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(str);
				//System.out.print(n);
				//rce.setN(n);
				rce = new RandomClickEvent(n);
				
			}
		});
		add(btn2);
		
//		jp.add(txtf);
//		Container contentPane = getContentPane();
//		contentPane.add(jp, BorderLayout.CENTER);
		
		setSize(250, 250);
		setLocation(100, 100);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
