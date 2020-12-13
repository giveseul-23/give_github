package Main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dao.im.DeleteView;
import Dao.im.InsertView;
import Dao.im.SelectView;
import Dao.im.UpdateView;

public class MainView extends JFrame implements ActionListener{
	JTextField txtf;
	JButton in_btn, de_btn, sel_btn, up_btn;
	
	public MainView() {
		setLayout(null);
		
		txtf = new JTextField();
		txtf.setText("원하는 메뉴를 선택하세요.");
		txtf.setBounds(10, 10, 460, 50);
		txtf.setHorizontalAlignment(JTextField.CENTER);
		add(txtf);
		
		in_btn = new JButton("Insert");
		in_btn.setBounds(10, 90, 460, 70);
		in_btn.addActionListener(this);
		add(in_btn);
		
		de_btn = new JButton("Delete");
		de_btn.setBounds(10, 180, 460, 70);
		de_btn.addActionListener(this);
		add(de_btn);
		
		sel_btn = new JButton("Select");
		sel_btn.setBounds(10, 270, 460, 70);
		sel_btn.addActionListener(this);
		add(sel_btn);
		
		up_btn = new JButton("Update");
		up_btn.setBounds(10, 360, 460, 70);
		up_btn.addActionListener(this);
		add(up_btn);
		
		setBounds(0, 0, 500, 500);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == in_btn) {
			dispose();
			new InsertView();
		}else if(e.getSource() == de_btn) {
			dispose();
			new DeleteView();
		}else if(e.getSource() == sel_btn) {
			dispose();
			new SelectView();
		}else if(e.getSource() == up_btn) {
			dispose();
			new UpdateView();
		}
	}
	
	
	
}
