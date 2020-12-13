package View;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Single.SingletonClass;
import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class InserView extends JPanel implements ActionListener, ItemListener{
	MyWindow win;
	
	JTextArea print;
	JTextField input[] = new JTextField[6];
	JPanel panel;
	Choice choice;
	JButton btn1, btn2;
	
	String p_title[] = {"이름", "나이", "키", "승", "패", "방어율"};
	String b_title[] = {"이름", "나이", "키", "타수", "안타수", "타율"};
	
	public InserView(MyWindow win) {
		this.win = win;
		
		setLayout(null);
		
		//super.setName("선수정보 입력");
		
		create();
		
		setBounds(0, 0, 640, 480);
		setBackground(new Color(247, 247, 247));
		setVisible(true);
		
	}
	
	public void create() {
		
		print = new JTextArea();
		print.setText("입력하신 선수정보가 출력됩니다.");
		print.setBackground(Color.white);
		print.setBounds(15, 50, 580, 210);
		add(print);
		
		choice = new Choice();
		choice.add("Pitcher");
		choice.add("Batter");
		choice.setBounds(460, 280, 200, 100);
		choice.addItemListener(this);
		add(choice);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 290, 640, 100);
		panel.setBackground(new Color(247, 247, 247));
		add(panel);
		
		for (int i = 0; i < input.length; i++) {
			input[i] = new JTextField(p_title[i]);
			input[i].setBounds(15+(100*i), 25, 80, 50);
			input[i].setBackground(Color.white);
			panel.add(input[i]);
		}
		
		btn1 = new JButton("SAVE");
		btn1.setBounds(15, 390, 580, 35);
		btn1.setOpaque(true);
		btn1.setFont(new Font("Calibri", Font.BOLD, 18));
		btn1.setBackground(new Color(242, 247, 255));
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new JButton("<< BACK");
		btn2.setBounds(15, 5, 100, 30);
		btn2.setOpaque(true);
		btn2.setFont(new Font("Calibri", Font.BOLD, 15));
		btn2.setBackground(new Color(242, 247, 255));
		btn2.addActionListener(this);
		add(btn2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SingletonClass si = SingletonClass.getInstance();
		Human h = null;
		
		if(e.getSource() == btn1) {
			
				for (int i = 0; i < input.length; i++) {
					if(input[i].getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "모두 작성해 주세요");
					}
				}
				
				String name = input[0].getText();
				int age = Integer.parseInt(input[1].getText());
				double height = Double.parseDouble(input[2].getText());
				int win = Integer.parseInt(input[3].getText());
				int lose = Integer.parseInt(input[4].getText());
				double defence = Double.parseDouble(input[5].getText());
				
			if(choice.getSelectedItem().equals("Pitcher")) {
				h = new Pitcher(0, name, age, height, win, lose, defence);
			}else if(choice.getSelectedItem().equals("Batter")) {
				h = new Batter(0, name, age, height, win, lose, defence);
			}
			
			boolean b = si.dao.insert(h);
			
			if(b == true) {
				JOptionPane.showMessageDialog(null, "입력완료");
				for (int i = 0; i < input.length; i++) {
					input[i].setText("");
				}
			}else {
				JOptionPane.showMessageDialog(null, "입력실패");
			}
			
		}
		
		print.setText("");
		for (int i = 0; i < (si.dao.list).size(); i++) {
			String str = si.dao.list.get(i).toString()+"\n";
			print.append(str);
		}
		
		if(e.getSource() == btn2) {
			win.getContentPane().removeAll();
			win.getContentPane().add(new MainView(win));
			win.revalidate();
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 
			if(choice.getSelectedItem().equals("Pitcher")) {
				panel.removeAll();
					for (int i = 0; i < input.length; i++) {
						input[i] = new JTextField(p_title[i]);
						input[i].setBounds(15+(100*i), 25, 80, 50);
						input[i].setBackground(Color.white);
						panel.add(input[i]);
					}
			}else if(choice.getSelectedItem().equals("Batter")) {
				panel.removeAll();
				for (int i = 0; i < input.length; i++) {
					input[i] = new JTextField(b_title[i]) ;
					input[i].setBounds(15+(100*i), 25, 80, 50);
					input[i].setBackground(Color.white);
					panel.add(input[i]);
				}
			}
			panel.revalidate();
			panel.repaint();		
		}

	
	
}
