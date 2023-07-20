package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener{
	
	private JPanel textPanel;
	private JPanel buttonsPanel;
	private JLabel txtField;
	private JButton[] buttons;
	private boolean firstPlayer = false;
	private Random random = new Random();
	
	public Frame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tic Tac Toe");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(500, 30));
		textPanel.setBackground(Color.black);
		textPanel.setLayout(new BorderLayout());
		txtField = new JLabel();
		txtField.setText("Tic Tac Toe");
		txtField.setHorizontalAlignment(JLabel.CENTER);
		txtField.setFont(new Font("Monospaced", Font.ITALIC, 30));
		txtField.setForeground(Color.white);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(500, 500));
		buttonsPanel.setLayout(new GridLayout(3, 3));
		
		textPanel.add(txtField);
		
		buttons = new JButton[9];
		
		for(int i = 0; i < 9; i++) {
			
			buttons[i] = new JButton();
			buttons[i].setText("");
			buttons[i].setFocusable(false);
			buttons[i].setFont(new Font("Monospaced", Font.ITALIC, 8));
			buttons[i].addActionListener(this);
			buttonsPanel.add(buttons[i]);
		}
		
		this.add(textPanel, BorderLayout.NORTH);
		this.add(buttonsPanel);
		this.pack();
		this.setVisible(true);
		start();
	}
	public void start() {
		
		if(random.nextInt(2) == 1) {
			this.firstPlayer = true;
		}else {
			this.firstPlayer = false;
		}
		
	}
	public boolean check() {
		
		if(
				buttons[0].getText() == "X" &&
				buttons[1].getText() == "X" &&
				buttons[2].getText() == "X") {
			
				xWins(0,1,2);
				return true;
		}
		if(
				buttons[3].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[5].getText() == "X") {
				
				xWins(3,4,5);
				return true;
		}
		if(
				buttons[6].getText() == "X" &&
				buttons[7].getText() == "X" &&
				buttons[8].getText() == "X") {
				
				xWins(6,7,8);				
				return true;
		}
		if(
				buttons[0].getText() == "X" &&
				buttons[3].getText() == "X" &&
				buttons[6].getText() == "X") {
				
				xWins(0,3,6);
				return true;
		}
		if(
				buttons[1].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[7].getText() == "X") {
				
				xWins(1,4,7);
				return true;
		}
		if(
				buttons[2].getText() == "X" &&
				buttons[5].getText() == "X" &&
				buttons[8].getText() == "X") {
				
				xWins(2,5,8);
				return true;

		}
		if(
				buttons[2].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[6].getText() == "X") {
				
				xWins(2,4,6);
				return true;

		}
		if(
				buttons[0].getText() == "X" &&
				buttons[4].getText() == "X" &&
				buttons[8].getText() == "X") {
				
				xWins(0,4,8);
				return true;

		}
		if(
				buttons[0].getText() == "O" &&
				buttons[1].getText() == "O" &&
				buttons[2].getText() == "O") {
			
				oWins(0,1,2);
				return true;

		}
		if(
				buttons[3].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[5].getText() == "O") {
				
				oWins(3,4,5);
				return true;

		}
		if(
				buttons[6].getText() == "O" &&
				buttons[7].getText() == "O" &&
				buttons[8].getText() == "O") {
				
				oWins(6,7,8);
				return true;

		}
		if(
				buttons[0].getText() == "O" &&
				buttons[3].getText() == "O" &&
				buttons[6].getText() == "O") {
				
				oWins(0,3,6);
				return true;

		}
		if(
				buttons[1].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[7].getText() == "O") {
				
				oWins(1,4,7);
				return true;

		}
		if(
				buttons[2].getText() == "O" &&
				buttons[5].getText() == "O" &&
				buttons[8].getText() == "O") {
				
				oWins(2,5,8);
				return true;

		}
		if(
				buttons[2].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[6].getText() == "O") {
				
				oWins(2,4,6);
				return true;

		}
		if(
				buttons[0].getText() == "O" &&
				buttons[4].getText() == "O" &&
				buttons[8].getText() == "O") {
				
				oWins(0,4,8);
				return true;

		}
		
		return false;
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 9; i++) {
			
			if(e.getSource() == buttons[i]) {
				
				if(firstPlayer) {
					
					if(buttons[i].getText() == "") {
						
						buttons[i].setForeground(Color.red);
						buttons[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
						buttons[i].setText("X");
						this.firstPlayer = false;
						
						if(check()) {
						 break;
						}
					}
				}
					else {
						
						if(buttons[i].getText() == "") {
							
							buttons[i].setForeground(Color.red);
							buttons[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
							buttons[i].setText("O");
							this.firstPlayer = true;
						
							if(check()) {
								break;
							}
					}
				}
			}
		}
	}
	
	public void xWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		txtField.setText("X player wins");
		
		for(int i = 0; i < 9; i++) {
			if(i == a || i == b || i == c) {
				continue;
			}else {
				buttons[i].setEnabled(true);
		}
	}
		
}
	public void oWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		txtField.setText("O player wins");
		
		for(int i = 0; i < 9; i++) {
			if(i == a || i == b || i == c) {
				continue;
			}else {
				buttons[i].setEnabled(true);
			}
		}
		
	}

	
}
