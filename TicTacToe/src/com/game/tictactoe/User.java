package com.game.tictactoe;

import java.util.Scanner;

public class User extends Player{
	
	 User(String name, char mark) {
		this.mark=mark;
		this.name=name;
	}
	
	public void makeMove() {
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		do {
			System.out.println("Enter the position");
			row = sc.nextInt();
			col = sc.nextInt();
		}while(!isValidMove(row,col));
		
		TicTacToe.placeMark(row, col, mark);
	}
	

}
