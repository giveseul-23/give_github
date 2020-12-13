package main;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class WindowTest extends Frame implements ActionListener, WindowListener, ItemListener {
	
	Checkbox cb1, cb2, cb3, cb4, cb5;		//swing -> JRadioButton
	Label label1, label2;
	
	Checkbox exitCheck;
	
	public WindowTest() {
		/*
		
			Radio Button  	AWT 지원안함, Swing은 지원함
							: 반드시 선택은 한 개만
							
			Check Box 		: 다수의 선택이 가능함
		
		*/
		
		CheckboxGroup cbg1 = new CheckboxGroup();
		cb1 = new Checkbox("사과", cbg1, true);
		cb2 = new Checkbox("배", cbg1, false);
		cb3 = new Checkbox("바나나", cbg1, false);
		
		CheckboxGroup cbg2 = new CheckboxGroup();
		cb4 = new Checkbox("빨강", cbg2, false);
		cb5 = new Checkbox("파랑", cbg2, true);
		
		exitCheck = new Checkbox("exit");
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(exitCheck);
		
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cb5.addItemListener(this);
		exitCheck.addItemListener(this);
		
		label1 = new Label("label1");
		label2 = new Label("label2");
		add(label1);
		add(label2);
		
		setLayout(new FlowLayout());
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		addWindowListener(this);
	}
	

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		
		//체크박스
		if(obj == exitCheck) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState() == true) {//체크된 상태
				System.exit(0);
			}
			else {	//체크 안된 상태
				
			}
		}
		
		//라디오버튼
		if(obj == cb1 || obj == cb2 || obj == cb3) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				String name = cb.getLabel();
				label1.setText(name); //cb에 얻어온 값 라벨에 텍스트 추가
			}
		}
		if(obj == cb4 || obj == cb5) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				String name = cb.getLabel();
				label2.setText(name); //cb에 얻어온 값 라벨에 텍스트 추가
			}
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
