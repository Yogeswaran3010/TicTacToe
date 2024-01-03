package com.game.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class AIPlayer extends Player{

	public AIPlayer(String name, char mark) {
		this.mark=mark;
		this.name=name;
	}

		public void makeMove() {
			int row;
			int col;
			do {
				Random r = new Random();
				row = r.nextInt(3);
				col = r.nextInt(3);
			}while(!isValidMove(row,col));
			
			TicTacToe.placeMark(row, col, mark);
		}
	
}


