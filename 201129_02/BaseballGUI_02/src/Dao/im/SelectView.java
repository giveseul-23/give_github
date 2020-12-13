package Dao.im;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dao.MemberDao;
import Main.MainView;
import Singleton.SingletonClass;
import util.UtilCls;

public class SelectView extends JFrame implements ActionListener{
	SingletonClass si = SingletonClass.getInstance();
	MemberDao dao = si.dao;
	UtilCls ut;
	
	JTextArea txta;
	JTextField txtf;
	JButton btn1, btn2;;
	
	public SelectView() {
		super("삭제");
		
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
		txta.setText("검색한 선수가 출력됩니다.");
		txta.setBounds(10, 60, 460, 250);
		add(txta);
		
		txtf = new JTextField();
		txtf.setText("검색하고 싶은 선수의 이름을 입력하세요");
		txtf.setBounds(10, 330, 340, 100);
		txtf.setHorizontalAlignment(JTextField.CENTER);
		add(txtf);
		
		btn1 = new JButton("입력");
		btn1.setBounds(360, 330, 100, 100);
		btn1.addActionListener(this);
		add(btn1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			String str = txtf.getText().trim();
			List<Integer> flist = ut.searchAll(str, dao.list);
			if(flist == null) {
				JOptionPane.showMessageDialog(null, "해당 선수의 이름이 존재하지 않습니다. 다시 입력하세요.", "선수를 찾을 수 없음", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				txta.setText("");
				for (int i = 0; i < flist.size(); i++) {
					String list = dao.list.get(flist.get(i)).toString()+"\n";
					txta.append(list);
				}
			}
		}
		
		if(e.getSource() == btn2) {
			dispose();
			new MainView();
		}
	}
	
}
