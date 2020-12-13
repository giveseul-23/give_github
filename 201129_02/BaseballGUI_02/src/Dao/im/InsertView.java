package Dao.im;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dao.MemberDao;
import Dto.Batter;
import Dto.Pitcher;
import Main.MainView;
import Singleton.SingletonClass;

public class InsertView extends JFrame implements ActionListener{
	SingletonClass si = SingletonClass.getInstance();
	
	JTextArea print, input;
	//JTextField txta;
	JButton btn1, btn2;
	Choice choice;
	int number;
	
	MemberDao dao = si.dao;
	int pi_num = dao.p_num;
	int bi_num = dao.b_num;
	
	public InsertView() {
		super("입력");
		
		setLayout(null);
		
		
		create();
		
		setBounds(0, 0, 500, 500);
		setVisible(true);
	}
	
	public void create() {
		btn2 = new JButton("메뉴로 돌아가기");
		btn2.setBounds(10, 10, 460, 30);
		btn2.addActionListener(this);
		add(btn2);
		
		print = new JTextArea();
		print.setLineWrap(true);
		print.setBounds(10, 60, 460, 250);
		add(print);
		
		input = new JTextArea();
		input.setText("양식에 맞춰 입력해주세요. : " + "\n" + "이름-나이-키-승(타수)-패(안타수)-방어율(타율)");
		input.setBounds(10, 330, 340, 100);
		add(input);
		
		btn1 = new JButton("입력");
		btn1.setBounds(360, 360, 110, 60);
		btn1.addActionListener(this);
		add(btn1);
		
		choice = new Choice();
		choice.add("투수(Pitcher)");
		choice.add("타수(Batter)");
		choice.setBounds(360, 330, 110, 20);
		add(choice);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1) {
			if(choice.getSelectedItem().equals("투수(Pitcher)")) {
				String str = input.getText()+"\n";
				str = ((pi_num+1000) + "-") + str;
				print.append(str);
				String data[] = str.split("-");
				dao.list.add(new Pitcher(Integer.parseInt(data[0]), 
														data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]),
										Double.parseDouble(data[6])));
				pi_num++;
			}else if(choice.getSelectedItem().equals("타수(Batter)")) {
				String str = input.getText()+"\n";
				str = ((bi_num+2000)+ "-") + str;
				print.append(str);
				String data[] = str.split("-");
				dao.list.add(new Batter(Integer.parseInt(data[0]), 
														data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]),
										Double.parseDouble(data[6])));
				bi_num++;
			}
			
		}
		
		if(e.getSource() == btn2) {
			dispose();
			new MainView();
		}
		
	}

	
	
}
