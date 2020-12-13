package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Net.WriteClass;

//대화명 
public class Id extends JFrame implements ActionListener {
	
	public static JTextField textf = new JTextField(8);
	JButton btn;
	
	ClientFrame cf;
	WriteClass wc;
	
	
	public Id(ClientFrame cf, WriteClass wc) {
		this.cf = cf;
		this.wc = wc;
		
		setTitle("대화명 window");
		setLayout(null);
		
		JLabel label = new JLabel("chatName");
		label.setBounds(50, 30, 120, 30);
		add(label);
		
		textf.setBounds(50, 70, 120, 30);
		add(textf);
		
		btn = new JButton("등록");
		btn.setBounds(50, 110, 120, 30);
		btn.addActionListener(this);
		add(btn);
		
		setBounds(200, 200, 250, 250);
		setBackground(Color.green);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		wc.sendMessage(); //전송됨
		
		cf.isFirst = false;	//위에서 전송했으니 isFirst는 false가 됨
		
		//클라이언트 프레임을 시각화
		cf.setVisible(true);
		
		//현재창은 close
		this.dispose();
	}

}
