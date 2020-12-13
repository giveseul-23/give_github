package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Net.WriteClass;

//채팅창
public class ClientFrame extends JFrame implements ActionListener {
	
	public Socket socket;
	
	public JTextField textf = new JTextField(24);
	public JTextArea texta = new JTextArea();
	
	JButton btnTransfer = new JButton("send");
	JButton btnExit = new JButton("Exit");
	
	JPanel panel = new JPanel();
	
	//서버로 첫 전송인지?
	public boolean isFirst = true;
	
	WriteClass wc;	//전송클래스
	
	public ClientFrame(Socket socket) {
		super("chatting");
		
		this.socket = socket;
							//지금 여기 자기자신 ClientFrame(=this)을 넣음
		wc = new WriteClass(this);
				
		new Id(this, wc);
		
		JScrollPane scrPane = new JScrollPane(texta);
		scrPane.setPreferredSize(new Dimension(200, 120));
		add("Center", scrPane);
		
		textf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(textf.getText().trim().equals("")) return;
					
					String id = Id.textf.getText();
					
					//textArea 에 추가
					texta.append("[" + id + "]" + textf.getText() + "\n");
					
					//server send
					wc.sendMessage();
					
					textf.setText("");
				}
			}
			
		});
		panel.add(textf);
		panel.add(btnTransfer);
		panel.add(btnExit);
		
		add("South", panel);
		
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		setBounds(200, 200, 450, 600);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnTransfer) {
		
			if(textf.getText().trim().equals("")) return;
			
			String id = Id.textf.getText();
			
			//textArea 에 추가
			texta.append("[" + id + "]" + textf.getText() + "\n");
			
			//server send
			wc.sendMessage(); //
			
			textf.setText("");
		}
		else if(obj == btnExit) {
			System.exit(0);
		}
	}

}
