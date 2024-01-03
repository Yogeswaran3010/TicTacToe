package com.game.tictactoe;

public class TicTacToe {

	static char[][] board;

	public TicTacToe() {
		board = new char[3][3];
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void displayBoard() {
		System.out.println("-------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			if (i < board.length - 1) {
				System.out.println("-------------"); // Horizontal line
			}
		}
		System.out.println("-------------");
	}

	 static void placeMark(int row, int col, char mark) {
		if (row >= 0 && row <= 2 && col <= 2 && col >= 0) {		
				board[row][col] = mark;
			
		} else {
			System.out.println("Invalid Position");
		}
	}

	public static boolean checkWin() {
		boolean isDone = false;
		// TODO Auto-generated method stub
		for (int j = 0; j < 3; j++) {
			//row wise
			if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[2][j] == board[1][j]) {
				System.out.println("Wins");
				isDone = true;
			}
		}

		if (!isDone) {
			for (int i = 0; i < 3; i++) {
				if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
					System.out.println("Wins");
					isDone = true;
				}
			}
		}

		if (!isDone) {

			if ((board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
					|| (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
				System.out.println("Wins");
			}
		}
		return isDone;

	}
	

}
