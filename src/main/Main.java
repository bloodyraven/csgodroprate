package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import ui.InputPanel;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("CS:GO Drop Rate");
		f.setSize(new Dimension(700, 450));
		f.setContentPane(new InputPanel(f));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
//		new Game();
	}
	
}
