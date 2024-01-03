package com.gui.integrate;

import javax.swing.JFrame;

public class GuiLaunch {

	public static void main(String[]args) {
		GuiBoard b = new GuiBoard();
		
		b.setVisible(true);
		b.setTitle("Tic Tac Toe");
		
		User p1 = new User("Human Player", "X");
		GuiBoard.placemark(p1.getMark(), p1.getName());

		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.setLocationRelativeTo(null);
	}
}
