package com.gui.integrate;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class GuiBoard extends JFrame {

	public static JButton[][] buttons;

	GuiBoard() {
		setSize(300, 300);
		setLayout(new GridLayout(3, 3));
		buttons = new JButton[3][3];
		initializeButtons();
	}

	private void initializeButtons() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				buttons[row][col] = new JButton("");
				buttons[row][col].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				buttons[row][col].setBackground(new Color(255, 182, 193));
				buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 40));
				buttons[row][col].setFocusPainted(false);
				buttons[row][col].setForeground(Color.BLACK);
				buttons[row][col].setText("");
				buttons[row][col].setHorizontalAlignment(SwingConstants.CENTER);
				buttons[row][col].setVerticalAlignment(SwingConstants.CENTER);

				add(buttons[row][col]);
			}
		}
	}

	public static void placemark(String Mark, String player) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				buttons[row][col].addActionListener(new GuiButtonListener(row, col, Mark, player));
			}
		}
	}
}
