package random;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RandomClickEvent extends JFrame{

	/*
	 * JLabel lbl; JPanel pan;
	 */

	JTextArea txta;
	JButton btn;
	JButton btnArr[][];
	int r;
	//int n;
	
//	public int getN() {
//		return n;
//	}
//
//	public void setN(int n) {
//		this.n = n;
//	}
	
	public void createBtnArr(int n) {
		int rowNum = (n-1)/3 + 1;

		btnArr = new JButton[rowNum][3];
		
		int i =0;
		for(int row=0; row<btnArr.length; row++) {
			for(int col=0; col<3; col++) {
				if(i<n) {
					btnArr[row][col] = new JButton((i+1)+"");
					JButton button = btnArr[row][col];
					button.setBounds(80+col*80, 130+row*80, 60, 60);
					button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(r == Integer.parseInt(button.getText())) {
								txta.setText("범인입니다.");
							}
							
							button.setEnabled(false);
						}
					});
					add(button);
				}
				i++;
				
			}
		}
	}

	public RandomClickEvent(int n) {
		super("랜덤이벤트");
		
		
		r = (int) (Math.random() * n) + 1;
		
		setLayout(null);

		txta = new JTextArea("결과가 나옵니다!");
		txta.setBounds(40, 50, 300, 50);
		txta.setBackground(Color.white);
		add(txta);
		
		createBtnArr(n);

		btn = new JButton("reset");
		btn.setBounds(40, 380, 300, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn) {
					txta.setText("다시 시작!");
					r = (int) (Math.random() * n) + 1;
					for (int i = 0; i < btnArr.length; i++) {
						for (int j = 0; j < btnArr[0].length; j++) {
							if(btnArr[i][j] != null) {
								btnArr[i][j].setEnabled(true);
							}
						}
					}
				}
			}
		});
		add(btn);

		setSize(400, 500);
		setLocation(100, 100);
		setVisible(true);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}



	
	

}
