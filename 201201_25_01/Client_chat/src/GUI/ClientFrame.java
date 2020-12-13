package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClientFrame extends JFrame implements ActionListener {
	
	public ClientFrame() {
		super("Chat");
		
		add(new ClientPanelOne(this));
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.white);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	
	
}
