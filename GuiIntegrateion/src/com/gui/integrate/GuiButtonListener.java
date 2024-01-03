package com.gui.integrate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GuiButtonListener implements ActionListener {
	private int row;
	private int col;
	private String mark;
	private String player;
	public static boolean result = false;

	public GuiButtonListener(int row, int col, String mark, String player) {
		this.row = row;
		this.col = col;
		this.mark = mark;
		this.setPlayer(player);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Button at row " + row + ", col " + col + " clicked.");
		handleButtonClick((JButton) e.getSource());

	}

	JButton click;

	private void handleButtonClick(JButton clickedButton) {
		//int[] position = getButtonPosition(clickedButton);
		GuiBoard.buttons[row][col].setEnabled(false);
		// Example: Output the clicked position
		System.out.println("Button at row " + row + ", col " + col + " clicked.");

		if (clickedButton.getText().equals("")) {
			// Example: Mark the button with the current player symbol
			clickedButton.setText(mark);

		}
		if (checkWin()) {
			endGame(player + " wins!");
		} else {
			boolean isBoardFull = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (GuiBoard.buttons[i][j].getText().equals("")) {
						isBoardFull = false;
						break;
					}
				}
			}
			if (isBoardFull) {
				endGame("It's a draw!");
			} else {
				player = "AI";
				mark = "O";
				makeAIMove();
				if (checkWin()) {
					endGame("AI (O) wins!");
				}
			}
		}
	}

	public static boolean checkWin() {
		boolean isDone = false;
		// TODO Auto-generated method stub
		for (int j = 0; j < 3; j++) {
			// row wise
			if (GuiBoard.buttons[0][j].getText() != ""
					&& GuiBoard.buttons[0][j].getText() == GuiBoard.buttons[1][j].getText()
					&& GuiBoard.buttons[2][j].getText() == GuiBoard.buttons[1][j].getText()) {
				System.out.println("Wins");
				isDone = true;
			}
		}

		if (!isDone) {
			for (int i = 0; i < 3; i++) {
				if (GuiBoard.buttons[i][0].getText() != ""
						&& GuiBoard.buttons[i][0].getText() == GuiBoard.buttons[i][1].getText()
						&& GuiBoard.buttons[i][1].getText() == GuiBoard.buttons[i][2].getText()) {
					System.out.println("Wins");
					isDone = true;

				}
			}
		}

		if (!isDone) {

			if ((GuiBoard.buttons[0][0].getText() != ""
					&& GuiBoard.buttons[0][0].getText() == GuiBoard.buttons[1][1].getText()
					&& GuiBoard.buttons[1][1].getText() == GuiBoard.buttons[2][2].getText())) {
				System.out.println("Wins");
				isDone = true;
			}

			if (GuiBoard.buttons[0][2].getText() != ""
					&& GuiBoard.buttons[0][2].getText() == GuiBoard.buttons[1][1].getText()
					&& GuiBoard.buttons[1][1].getText() == GuiBoard.buttons[2][0].getText()) {
				System.out.println("Wins");
				isDone = true;
			}
		}
		return isDone;

	}

	private void makeAIMove() {
		// Find the first empty spot and place 'O'
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if (GuiBoard.buttons[i][j].getText().equals("")) {
//					GuiBoard.buttons[i][j].setText("O");
//					GuiBoard.buttons[i][j].setEnabled(false);
//					player = "Human Player";
//					mark = "X";
//					return;
//				}
//			}
//		}
		
		 Random random = new Random(); int randomRow, randomCol;
		  
		  do { randomRow = random.nextInt(3); randomCol = random.nextInt(3); } while
		  (!GuiBoard.buttons[randomRow][randomCol].getText().equals(""));
		  
		  GuiBoard.buttons[randomRow][randomCol].setText("O");
		  GuiBoard.buttons[randomRow][randomCol].setEnabled(false); 
		  player ="Human Player";
		  mark = "X"; return;
		 
	    }
	

	private void endGame(String result) {
		JOptionPane.showMessageDialog(click, result, "Game Over", JOptionPane.INFORMATION_MESSAGE);
		resetGame();
	}

	private void resetGame() {
		player = "Yoges";
		mark = "X";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				GuiBoard.buttons[i][j].setText("");
				GuiBoard.buttons[i][j].setEnabled(true);
			}
		}

	}

	// Helper method to get the position of a button in the array
	

	public void setPlayer(String player) {
		this.player = player;
	}
}
