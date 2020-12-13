package main;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class WindowText_Swing extends JFrame implements ActionListener, ItemListener{
	JRadioButton rdb1, rdb2, rdb3, rdb4, rdb5;
	Label lbl1, lbl2;
	
	Checkbox cbox;
	
	public WindowText_Swing() {
		
		ButtonGroup bg1 = new ButtonGroup();
		rdb1 = new JRadioButton("사과");
		rdb2 = new JRadioButton("딸기");
		rdb3 = new JRadioButton("배");
		
		rdb1.setSelected(true);
		
		bg1.add(rdb1);
		bg1.add(rdb2);
		bg1.add(rdb3);
		
		ButtonGroup bg2 = new ButtonGroup();
		rdb4 = new JRadioButton("빨강");
		rdb5 = new JRadioButton("파랑");
		
		rdb5.setSelected(true);
		bg2.add(rdb4);
		bg2.add(rdb5);
		
		add(rdb1);
		add(rdb2);
		add(rdb3);
		add(rdb4);
		add(rdb5);
		
		cbox = new Checkbox("exit");
		add(cbox);
		
		lbl1 = new Label("라벨1");
		lbl2 = new Label("라벨2");
		add(lbl1);
		add(lbl2);
		
		setLayout(new FlowLayout());
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		
		//체크박스
		if(obj == cbox) {
			Checkbox cb = (Checkbox)e.getSource();
			if(cb.getState()) {
				System.exit(0);
			}else {
				
			}
		}
		
		//라디오버튼
		if(rdb1.isSelected() || rdb2.isSelected() || rdb3.isSelected()) {
			JRadioButton jb = (JRadioButton)e.getSource();
			//if(jb.)
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
