package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientPanelOne extends JPanel{
	
	ClientFrame cf;
	
	JLabel label;
	JTextField txtf;
	JButton btn;
	String str;
	
	public ClientPanelOne(ClientFrame cf) {
		this.cf = cf;
		
		setLayout(null);
		
		create();
		
		setBounds(0, 0, 640, 480);
		setBackground(new Color(218, 255, 247));
		setVisible(true);
	}
	
	public void create() {
		label = new JLabel();
		label.setText("Create Chat Name?");
		label.setFont(new Font("helvetica", Font.BOLD, 40));
		label.setBackground(Color.white);
		label.setBounds(74, 80, 500, 100);
		add(label);
		
		txtf = new JTextField();
		txtf.setText("채팅방명을 입력해 주세요.");
		txtf.setBounds(74, 200, 400, 50);
		add(txtf);
		
		
		btn = new JButton("Click");
		btn.setFont(new Font("helvetica", Font.ITALIC, 20));
		btn.setBounds(500, 200, 80, 50);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				str = txtf.getText();
				if(e.getSource() == btn) {
					if(!(str.equals(""))) {
						JOptionPane.showMessageDialog(null, str+" 채팅방으로 입장합니다.");
						cf.getContentPane().removeAll();
						cf.getContentPane().add(new ClientPanelTwo(cf));
						cf.revalidate();
					}else if(str.equals("")){
						JOptionPane.showMessageDialog(null, "작성해 주십시오.");
					}
					
				}
			}
		});
		add(btn);
	}

	public String getStr() {
		return str;
	}

	
}
