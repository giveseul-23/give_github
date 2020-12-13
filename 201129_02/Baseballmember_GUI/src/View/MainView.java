package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainView extends JPanel implements ActionListener{
	MyWindow win;
	
	JLabel label;
	JButton btn[] = new JButton[5];
	ButtonGroup btn_g;
	
	public MainView(MyWindow win) {
		super.setName("베이스볼 프로그램 메뉴");
		
		this.win = win;
		
		setLayout(null);
		
		create();
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.white);
		setVisible(true);
		
	}
	
	public void create() {
		label = new JLabel("BASEBALL PROGRAM");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Calibri", Font.BOLD, 50));
		label.setBounds(20, 30, 450, 50);
		add(label);
		
		
		String btn_title[] = {"Insert", "Delete", "Search", "Update", "FileSave"}; 
		
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btn_title[i]);
			btn[i].setFont(new Font("Calibri", Font.ITALIC, 30));
			btn[i].setOpaque(true);
			btn[i].setBackground(new Color(242, 247, 255));
			btn[i].setBounds(200, 100+(i*65), 350, 50);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn[0]) {
			//JOptionPane.showMessageDialog(null, "click");
			win.getContentPane().removeAll();
			win.getContentPane().add(new InserView(win));
			win.revalidate();
		}

	}
	
	
}
