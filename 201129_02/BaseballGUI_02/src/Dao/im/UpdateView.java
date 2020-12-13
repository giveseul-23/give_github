package Dao.im;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dao.MemberDao;
import Dto.Batter;
import Dto.Pitcher;
import Main.MainView;
import Singleton.SingletonClass;
import util.UtilCls;

public class UpdateView extends JFrame implements ActionListener{
	SingletonClass si = SingletonClass.getInstance();
	MemberDao dao = si.dao;
	UtilCls ut;
	
	JTextArea txta;
	JTextField txtf1, txtf2, txtf3, txtf4;
	JButton btn1, btn2;
	Choice choice;
	
	public UpdateView() {
		super("수정");
		
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
		
		txta = new JTextArea();
		txta.setBounds(10, 70, 460, 250);
		for (int i = 0; i < dao.list.size(); i++) {
			String str = dao.list.get(i).toString()+"\n";
			txta.append(str);
		}
		add(txta);
		
		txtf1 = new JTextField();
		txtf1.setText("선수이름");
		txtf1.setBounds(10, 350, 80, 80);
		txtf1.setHorizontalAlignment(JTextField.CENTER);
		add(txtf1);
		
		txtf2 = new JTextField();
		txtf2.setText("승(타수)");
		txtf2.setBounds(100, 350, 80, 80);
		txtf2.setHorizontalAlignment(JTextField.CENTER);
		add(txtf2);
		
		txtf3 = new JTextField();
		txtf3.setText("패(안타수)");
		txtf3.setBounds(190, 350, 80, 80);
		txtf3.setHorizontalAlignment(JTextField.CENTER);
		add(txtf3);
		
		txtf4 = new JTextField();
		txtf4.setText("방어율(타율)");
		txtf4.setBounds(280, 350, 80, 80);
		txtf4.setHorizontalAlignment(JTextField.CENTER);
		add(txtf4);
		
		choice = new Choice();
		choice.add("투수(Pitcher)");
		choice.add("타수(Batter)");
		choice.setBounds(370, 350, 110, 20);
		add(choice);
		
		btn1 = new JButton("입력");
		btn1.setBounds(370, 380, 110, 50);
		btn1.addActionListener(this);
		add(btn1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1) {
			if(txtf1 != null && txtf2 != null && txtf3 != null && txtf4 != null) {
				String name = txtf1.getText().trim();
				int index = ut.search(name, dao.list);
				if(index == -1) {
					JOptionPane.showMessageDialog(null, "해당 선수의 이름이 존재하지 않습니다. 다시 입력하세요.", "선수를 찾을 수 없음", JOptionPane.ERROR_MESSAGE);
				}else {
					int input1 = Integer.parseInt(txtf2.getText().trim());
					int input2 = Integer.parseInt(txtf3.getText().trim());
					double input3 = Double.parseDouble(txtf4.getText().trim());
					
					if(choice.getSelectedItem().equals("투수(Pitcher)")) {
						Pitcher p = (Pitcher)(dao.list.get(index));
						p.setWin(input1);
						p.setLose(input2);
						p.setDefence(input3);
					}else if(choice.getSelectedItem().equals("타수(Batter)")) {
						Batter b = (Batter)(dao.list.get(index));
						b.setBatcount(input1);
						b.setHit(input2);
						b.setHitAvg(input3);
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "입력값이 없습니다. 다시 입력하세요.", "입력값 없음", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		txta.setText("");
		for (int i = 0; i < dao.list.size(); i++) {
			String str = dao.list.get(i).toString()+"\n";
			txta.append(str);
		}
	
		if(e.getSource() == btn2) {
			dispose();
			new MainView();
		}
	}
	

}
