package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientPanelTwo extends JPanel implements ActionListener {
	
	ClientFrame cf;
	JLabel label;
	JTextArea txta;
	JTextField txtf;
	JButton btn;
	String str;
	
	public ClientPanelTwo(ClientFrame cf) {
		this.cf = cf;
		
		ClientPanelOne po = new ClientPanelOne(cf);
		str = po.getStr();
		
		setLayout(null);
		
		create();
		
		setBounds(0, 0, 640, 480);
		setBackground(new Color(218, 255, 247));
		setVisible(true);
		
	}
	
	public void create() {
		label = new JLabel();
		label.setText(str);
		label.setBounds(20, 10, 150, 50);
		add(label);
		
		txta = new JTextArea();
		txta.setText("내용이 입력됩니다.");
		txta.setBounds(20, 60, 580, 280);
		add(txta);
		
		txtf = new JTextField();
		txtf.setText("내용을 입력해 주세요.");
		txtf.setBounds(20, 360, 480, 50);
		add(txtf);
		
		btn = new JButton("Click");
		btn.setBounds(510, 360, 85, 50);
		btn.addActionListener(this);
		add(btn);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String sentance = txtf.getText();
		
		if(e.getSource() == btn) {
			if(sentance.equals("")) {
				JOptionPane.showMessageDialog(null, "입력해 주세요.");
				return;
			}
			
			txta.setText("");
			
			if(!(sentance.equals(""))){
				txtf.setText("");
				txta.append(sentance);
			}
		}
	}

}
