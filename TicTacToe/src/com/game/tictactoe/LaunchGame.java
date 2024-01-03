package com.game.tictactoe;

public class LaunchGame {
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();

		User p1 = new User("Yoges", 'X');
		AIPlayer ai = new AIPlayer("AI", 'O');

		Player cp;
		cp = p1;
		while (true) {
			System.out.println(cp.name + " turn now");
			cp.makeMove();
			t.displayBoard();
			if (TicTacToe.checkWin()) {
				System.out.println(cp.name + " has won");
				break;
			} else {
				if (cp == p1) {
					cp = ai;
				} else {
					cp = p1;
				}
			}
		}
		
		
	}
}
