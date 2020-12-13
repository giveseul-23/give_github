package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PanelTwo extends Panel implements ActionListener{

	WindowTest wt;
	
	public PanelTwo(WindowTest wt) {
		this.wt = wt;
		setLayout(null);
		
		Label label = new Label("Panel Two");
		label.setBounds(0, 0, 200, 30);
		label.setBackground(Color.cyan);
		add(label);
		
		Button btn = new Button("click");
		btn.setBounds(150, 100, 100, 30);
		btn.addActionListener(this);
		add(btn);
				
		setBounds(0, 0, 640, 480);
		setBackground(Color.blue);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		wt.removeAll(); //swing 에서는 wt.getcontentpane().removeall();
		wt.add(new PanelOne(wt)); // wt.getcontentpane().add(new PanelOne(wt));
		wt.revalidate();
	}

	
	
	
}
