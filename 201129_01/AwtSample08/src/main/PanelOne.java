package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PanelOne extends Panel {

	WindowTest wt;
	
	public PanelOne(WindowTest wt) {
		this.wt = wt;
		setLayout(null);
		
		Label label = new Label("Panel One");
		label.setBounds(0, 0, 200, 30);
		label.setBackground(Color.cyan);
		add(label);
				
		Button btn = new Button("click");
		btn.setBounds(100, 100, 100, 30);
		btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	JOptionPane.showMessageDialog(null, "click");
				wt.removeAll();						
				wt.add(new PanelTwo(wt));
				wt.revalidate();			
			}
		});
		add(btn);
				
		setBounds(0, 0, 640, 480);
		setBackground(Color.red);		
	}

	
	
	
	
}
